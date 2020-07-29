package com.project.ratingsystem.repository;

import com.project.ratingsystem.entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingsRepository extends JpaRepository<Ratings, Integer>, JpaSpecificationExecutor<Ratings> {


    List<Ratings> findAllByDriverId(Integer driverId);

    List<Ratings> findAllByPassengerId(Integer passengerId);

    Ratings save(Ratings rating);

    Ratings findByRideId(Integer rideId);
}