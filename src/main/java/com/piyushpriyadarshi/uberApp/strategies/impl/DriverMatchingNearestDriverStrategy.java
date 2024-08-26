package com.piyushpriyadarshi.uberApp.strategies.impl;

import com.piyushpriyadarshi.uberApp.dto.RideRequestDto;
import com.piyushpriyadarshi.uberApp.entities.Driver;
import com.piyushpriyadarshi.uberApp.entities.RideRequest;
import com.piyushpriyadarshi.uberApp.repositories.DriverRepository;
import com.piyushpriyadarshi.uberApp.strategies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {


    private DriverRepository driverRepository;

    @Override
    public List<Driver> findMatchingDrivers(RideRequest rideRequest) {
        return driverRepository.findTenNearestDrivers(rideRequest.getPickupLocation());
    }
}
