package com.piyushpriyadarshi.uberApp.services;

import com.piyushpriyadarshi.uberApp.dto.DriverDto;
import com.piyushpriyadarshi.uberApp.dto.RiderDto;
import com.piyushpriyadarshi.uberApp.entities.Ride;
import com.piyushpriyadarshi.uberApp.entities.Rider;

public interface RatingService {

    DriverDto rateDriver(Ride ride, Integer rating);

    RiderDto rateRider(Ride ride, Integer rating);

    void createRating(Ride ride);
}
