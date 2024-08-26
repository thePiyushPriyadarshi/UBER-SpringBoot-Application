package com.piyushpriyadarshi.uberApp.services.impl;

import com.piyushpriyadarshi.uberApp.dto.RideRequestDto;
import com.piyushpriyadarshi.uberApp.entities.Driver;
import com.piyushpriyadarshi.uberApp.entities.Ride;
import com.piyushpriyadarshi.uberApp.entities.enums.RideStatus;
import com.piyushpriyadarshi.uberApp.services.RideService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class RideServiceImpl implements RideService {
    @Override
    public Ride getRideById(Long rideId) {
        return null;
    }

    @Override
    public void matchWithDrivers(RideRequestDto rideRequestDto) {

    }

    @Override
    public Ride createNewRide(RideRequestDto rideRequestDto, Driver driver) {
        return null;
    }

    @Override
    public Ride updateRideStatus(Long rideId, RideStatus rideStatus) {
        return null;
    }

    @Override
    public Page<Ride> getAllRidesOfRider(Long riderId, PageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<Ride> getAllRidesOfDriver(Long driverId, PageRequest pageRequest) {
        return null;
    }
}
