package com.piyushpriyadarshi.uberApp.repositories;

import com.piyushpriyadarshi.uberApp.entities.Driver;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//
//ST_Distance(point1,point2)
//ST_DWithin(point1,point2)

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

    @Query(value = "SELECT d.*,ST_Distance(d.current_location, :pickupLocation) AS distance" +
            "FROM driver d " +
            "where d.available = true AND ST_DWithin(d.current_location,:pickupLocation,10000)" +
            "ORDER BY distance " +
            "limit 10", nativeQuery = true)
    List<Driver> findTenNearestDrivers(Point pickupLocation);
}
