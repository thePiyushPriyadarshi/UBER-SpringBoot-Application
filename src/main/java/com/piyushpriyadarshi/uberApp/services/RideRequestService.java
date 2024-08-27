package com.piyushpriyadarshi.uberApp.services;

import com.piyushpriyadarshi.uberApp.entities.RideRequest;

public interface RideRequestService {

    RideRequest findRideRequestById(Long rideRequestId);

    void update(RideRequest rideRequest);
}
