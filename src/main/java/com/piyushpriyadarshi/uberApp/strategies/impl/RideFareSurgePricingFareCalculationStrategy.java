package com.piyushpriyadarshi.uberApp.strategies.impl;

import com.piyushpriyadarshi.uberApp.entities.RideRequest;
import com.piyushpriyadarshi.uberApp.strategies.RideFareCalculationStrategy;
import org.springframework.stereotype.Service;

@Service
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {

    @Override
    public double calculateFare(RideRequest rideRequest) {
        return 0;
    }
}
