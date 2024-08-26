package com.piyushpriyadarshi.uberApp.services.impl;

import com.piyushpriyadarshi.uberApp.dto.DriverDto;
import com.piyushpriyadarshi.uberApp.dto.RideDto;
import com.piyushpriyadarshi.uberApp.dto.RideRequestDto;
import com.piyushpriyadarshi.uberApp.dto.RiderDto;
import com.piyushpriyadarshi.uberApp.entities.RideRequest;
import com.piyushpriyadarshi.uberApp.entities.Rider;
import com.piyushpriyadarshi.uberApp.entities.User;
import com.piyushpriyadarshi.uberApp.entities.enums.RideRequestStatus;
import com.piyushpriyadarshi.uberApp.repositories.RideRequestRepository;
import com.piyushpriyadarshi.uberApp.repositories.RiderRepository;
import com.piyushpriyadarshi.uberApp.services.RiderService;
import com.piyushpriyadarshi.uberApp.strategies.DriverMatchingStrategy;
import com.piyushpriyadarshi.uberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RiderServiceImpl implements RiderService {

    private final ModelMapper modelMapper;
//    private final RideFareCalculationStrategy rideFareCalculationStrategy;
//    private final DriverMatchingStrategy driverMatchingStrategy;
    private final RideRequestRepository rideRequestRepository;
    private final RiderRepository riderRepository;

    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {

        RideRequest rideRequest = modelMapper.map(rideRequestDto,RideRequest.class);
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);

//        Double fare = rideFareCalculationStrategy.calculateFare(rideRequest);
//        rideRequest.setFare(fare);

        RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);


//        driverMatchingStrategy.findMatchingDrivers(rideRequest);

        return modelMapper.map(savedRideRequest,RideRequestDto.class);
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDto rateDriver(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RiderDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRides() {
        return List.of();
    }

    @Override
    public Rider createNewRider(User user) {
        Rider rider = Rider.builder().user(user).rating(0.0).build();
        return riderRepository.save(rider);
    }
}
