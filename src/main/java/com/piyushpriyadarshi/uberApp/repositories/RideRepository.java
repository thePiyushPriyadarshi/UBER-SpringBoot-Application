package com.piyushpriyadarshi.uberApp.repositories;

import com.piyushpriyadarshi.uberApp.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride,Long> {
}
