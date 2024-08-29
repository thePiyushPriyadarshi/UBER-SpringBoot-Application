package com.piyushpriyadarshi.uberApp.services.impl;

import com.piyushpriyadarshi.uberApp.dto.DriverDto;
import com.piyushpriyadarshi.uberApp.dto.RiderDto;
import com.piyushpriyadarshi.uberApp.entities.Driver;
import com.piyushpriyadarshi.uberApp.entities.Rating;
import com.piyushpriyadarshi.uberApp.entities.Ride;
import com.piyushpriyadarshi.uberApp.entities.Rider;
import com.piyushpriyadarshi.uberApp.exceptions.ResourceNotFoundException;
import com.piyushpriyadarshi.uberApp.exceptions.RuntimeConflictException;
import com.piyushpriyadarshi.uberApp.repositories.DriverRepository;
import com.piyushpriyadarshi.uberApp.repositories.RatingRepository;
import com.piyushpriyadarshi.uberApp.repositories.RiderRepository;
import com.piyushpriyadarshi.uberApp.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final DriverRepository driverRepository;
    private final RiderRepository riderRepository;
    private final ModelMapper modelMapper;


    @Override
    public DriverDto rateDriver(Ride ride, Integer rating) {

        Driver driver = ride.getDriver();
        Rating ratingObj = ratingRepository.findByRide(ride).orElseThrow(()->
                new ResourceNotFoundException("Rating is not found with ride id  : "+ride.getId()));

        if(ratingObj.getDriverRating()!=null){
            throw new RuntimeConflictException("Driver has been already rated,Cannot rate again");
        }

        ratingObj.setDriverRating(rating);

        ratingRepository.save(ratingObj);

        Double newRating = ratingRepository.findByDriver(driver)
                .stream().mapToDouble(Rating::getDriverRating)
                .average().orElse(0.0);

        driver.setRating(newRating);
        return  modelMapper.map(driverRepository.save(driver),DriverDto.class);


    }

    @Override
    public RiderDto rateRider(Ride ride, Integer rating) {


        Rider rider = ride.getRider();
        Rating ratingObj = ratingRepository.findByRide(ride).orElseThrow(()->
                new ResourceNotFoundException("Rating is not found with ride id  : "+ride.getId()));

        if(ratingObj.getRiderRating()!=null){
            throw new RuntimeConflictException("Rider has been already rated,Cannot rate again");
        }
        ratingObj.setRiderRating(rating);

        ratingRepository.save(ratingObj);

        Double newRating = ratingRepository.findByRider(rider)
                .stream().mapToDouble(Rating::getRiderRating)
                .average().orElse(0.0);

        rider.setRating(newRating);
        return modelMapper.map(riderRepository.save(rider),RiderDto.class);

    }

    @Override
    public void createRating(Ride ride) {
        Rating rating = Rating.builder()
                .ride(ride)
                .driver(ride.getDriver())
                .rider(ride.getRider())
                .build();

        ratingRepository.save(rating);
    }
}
