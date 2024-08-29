package com.piyushpriyadarshi.uberApp.services;

import com.piyushpriyadarshi.uberApp.dto.DriverDto;
import com.piyushpriyadarshi.uberApp.dto.RideDto;
import com.piyushpriyadarshi.uberApp.dto.RiderDto;
import com.piyushpriyadarshi.uberApp.entities.Driver;
import com.piyushpriyadarshi.uberApp.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface DriverService {

    RideDto acceptRide(Long rideRequestId);

    RideDto cancelRide(Long rideId);

    RideDto startRide(Long rideId,String otp);

    RideDto endRide(Long rideId);

    RiderDto rateRider(Long rideId,Integer rating);

    DriverDto getMyProfile();

    Page<RideDto> getAllMyRides(PageRequest pageRequest);

    Driver getCurrentDriver();

    Driver updateDriverAvailability(Driver driver,boolean available);

    Driver createNewDriver(Driver driver);

}
