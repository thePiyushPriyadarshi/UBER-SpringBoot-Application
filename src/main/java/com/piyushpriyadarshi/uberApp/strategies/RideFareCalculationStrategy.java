package com.piyushpriyadarshi.uberApp.strategies;

import com.piyushpriyadarshi.uberApp.entities.RideRequest;

public interface RideFareCalculationStrategy {

    double RIDE_FARE_MULTIPLIER = 10;
    double calculateFare(RideRequest rideRequest);
}
