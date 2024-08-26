package com.piyushpriyadarshi.uberApp.repositories;

import com.piyushpriyadarshi.uberApp.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepository extends JpaRepository<Rider,Long> {
}
