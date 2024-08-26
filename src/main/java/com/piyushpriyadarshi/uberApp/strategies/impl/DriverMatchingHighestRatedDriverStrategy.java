package com.piyushpriyadarshi.uberApp.strategies.impl;

import com.piyushpriyadarshi.uberApp.dto.RideRequestDto;
import com.piyushpriyadarshi.uberApp.entities.Driver;
import com.piyushpriyadarshi.uberApp.entities.RideRequest;
import com.piyushpriyadarshi.uberApp.strategies.DriverMatchingStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchingStrategy {

    @Override
    public List<Driver> findMatchingDrivers(RideRequest rideRequest) {
        return List.of();
    }
}
