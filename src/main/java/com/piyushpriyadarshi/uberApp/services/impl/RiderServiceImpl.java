package com.piyushpriyadarshi.uberApp.services.impl;

import com.piyushpriyadarshi.uberApp.dto.DriverDto;
import com.piyushpriyadarshi.uberApp.dto.RideDto;
import com.piyushpriyadarshi.uberApp.dto.RideRequestDto;
import com.piyushpriyadarshi.uberApp.dto.RiderDto;
import com.piyushpriyadarshi.uberApp.entities.*;
import com.piyushpriyadarshi.uberApp.entities.enums.RideRequestStatus;
import com.piyushpriyadarshi.uberApp.entities.enums.RideStatus;
import com.piyushpriyadarshi.uberApp.exceptions.ResourceNotFoundException;
import com.piyushpriyadarshi.uberApp.repositories.RideRequestRepository;
import com.piyushpriyadarshi.uberApp.repositories.RiderRepository;
import com.piyushpriyadarshi.uberApp.services.DriverService;
import com.piyushpriyadarshi.uberApp.services.RatingService;
import com.piyushpriyadarshi.uberApp.services.RideService;
import com.piyushpriyadarshi.uberApp.services.RiderService;
import com.piyushpriyadarshi.uberApp.strategies.RideStrategyManager;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RiderServiceImpl implements RiderService {

    private final ModelMapper modelMapper;
    private final RideStrategyManager rideStrategyManager;
    private final RideRequestRepository rideRequestRepository;
    private final RiderRepository riderRepository;
    private final RideService rideService;
    private final DriverService driverService;
    private final RatingService ratingService;

    @Override
    @Transactional
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {

        Rider rider = getCurrentRider();
        RideRequest rideRequest = modelMapper.map(rideRequestDto,RideRequest.class);
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
        rideRequest.setRider(rider);

        Double fare = rideStrategyManager.rideFareCalculationStrategy().calculateFare(rideRequest);
        rideRequest.setFare(fare);

        RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);


        rideStrategyManager.driverMatchingStrategy(rider.getRating()).findMatchingDrivers(rideRequest);

        return modelMapper.map(savedRideRequest,RideRequestDto.class);
    }

    @Override
    public RideDto cancelRide(Long rideId) {

        Rider rider = getCurrentRider();
        Ride ride = rideService.getRideById(rideId);

        if(!rider.equals(ride.getRider())){
            throw new RuntimeException("Rider does not own this ride with id : "+rideId);
        }
        if(!ride.getRideStatus().equals(RideStatus.CONFIRMED)){
            throw new RuntimeException("Ride cannot be cancelled, invalid Status : "+ride.getRideStatus());
        }
        rideService.updateRideStatus(ride,RideStatus.CANCELLED);
        driverService.updateDriverAvailability(ride.getDriver(),true);

        return modelMapper.map(ride,RideDto.class);

    }

    @Override
    public DriverDto rateDriver(Long rideId, Integer rating) {
        Ride ride = rideService.getRideById(rideId);
        Rider currentRider = getCurrentRider();

        if(!currentRider.equals(ride.getRider())){
            throw new RuntimeException("Rider is not the owner of this Ride");
        }
        if(!ride.getRideStatus().equals(RideStatus.ENDED)){
            throw new RuntimeException("Ride status is not Ended ,hence cannot start rating");
        }

        return ratingService.rateDriver(ride,rating);
    }

    @Override
    public RiderDto getMyProfile() {
       Rider currentRider = getCurrentRider();
        return modelMapper.map(currentRider,RiderDto.class);
    }

    @Override
    public Page<RideDto> getAllMyRides(PageRequest pageRequest) {
        Rider currentRider = getCurrentRider();
        return rideService.getAllRidesOfRider(currentRider,pageRequest).map(ride -> modelMapper.map(ride,RideDto.class));

    }

    @Override
    public Rider createNewRider(User user) {
        Rider rider = Rider.builder().user(user).rating(0.0).build();
        return riderRepository.save(rider);
    }

    @Override
    public Rider getCurrentRider() {

        return riderRepository.findById(1L).orElseThrow(()-> new ResourceNotFoundException("Ride not found"));
    }
}
