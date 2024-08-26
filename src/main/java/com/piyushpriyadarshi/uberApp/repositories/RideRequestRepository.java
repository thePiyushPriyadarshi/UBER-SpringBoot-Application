package com.piyushpriyadarshi.uberApp.repositories;

import com.piyushpriyadarshi.uberApp.entities.RideRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRequestRepository extends JpaRepository<RideRequest,Long> {
}
