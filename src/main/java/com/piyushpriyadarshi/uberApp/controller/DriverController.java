package com.piyushpriyadarshi.uberApp.controller;

import com.piyushpriyadarshi.uberApp.dto.RideDto;
import com.piyushpriyadarshi.uberApp.dto.StartRideDto;
import com.piyushpriyadarshi.uberApp.services.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @PostMapping("/acceptRide/{rideRequestId}")
    public RideDto acceptRide(@PathVariable Long rideRequestId){

        return driverService.acceptRide(rideRequestId);
    }

    @PostMapping("/startRide/{rideId}")
    public RideDto startRide(@PathVariable Long rideId,@RequestBody StartRideDto startRideDto){

        return driverService.startRide(rideId,startRideDto.getOtp());
    }
}
