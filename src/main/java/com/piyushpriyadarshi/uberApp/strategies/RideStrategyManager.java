package com.piyushpriyadarshi.uberApp.strategies;

import com.piyushpriyadarshi.uberApp.strategies.impl.DriverMatchingHighestRatedDriverStrategy;
import com.piyushpriyadarshi.uberApp.strategies.impl.DriverMatchingNearestDriverStrategy;
import com.piyushpriyadarshi.uberApp.strategies.impl.RideFareDefaultCalculationStrategy;
import com.piyushpriyadarshi.uberApp.strategies.impl.RideFareSurgePricingFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {

    private final DriverMatchingHighestRatedDriverStrategy highestRatedDriverStrategy;
    private final DriverMatchingNearestDriverStrategy nearestDriverStrategy;
    private final RideFareDefaultCalculationStrategy defaultCalculationStrategy;
    private final RideFareSurgePricingFareCalculationStrategy surgePricingFareCalculationStrategy;


    public DriverMatchingStrategy driverMatchingStrategy(double riderRating){

        if(riderRating>=4.8){
            return highestRatedDriverStrategy;
        }else{
            return nearestDriverStrategy;
        }
    }

    public RideFareCalculationStrategy rideFareCalculationStrategy(){

        // peak hour : 6PM to 9PM
        LocalTime surgeStartTime = LocalTime.of(18,0);
        LocalTime surgeEndTime = LocalTime.of(21,0);
        LocalTime currentTime = LocalTime.now();

        boolean isSurgeTIme = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);

        if(isSurgeTIme){
            return surgePricingFareCalculationStrategy;
        }else{
            return defaultCalculationStrategy;
        }

    }

}
