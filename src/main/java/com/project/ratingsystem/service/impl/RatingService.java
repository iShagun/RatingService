package com.project.ratingsystem.service.impl;

import com.project.ratingsystem.entity.Ratings;
import com.project.ratingsystem.repository.RatingsRepository;
import com.project.ratingsystem.request.RatingRequest;
import com.project.ratingsystem.response.ApiResponse;
import com.project.ratingsystem.service.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("ratingService")
public class RatingService implements IRatingService {

    @Autowired
    private RatingsRepository ratingsRepository;

    @Override
    public ApiResponse<String> rateDriver(RatingRequest request) {
        try {
            Ratings existingRating = ratingsRepository.findByRideId(request.getRideId());
            if(Objects.nonNull(existingRating))
            {
                existingRating.setDriverRating(request.getDriverRating());
                existingRating.setPassengerName(request.getPassengerName());
                existingRating.setPassengerId(request.getPassengerId());
            }
            else
            {
                Ratings rating = Ratings.builder()
                        .rideId(request.getRideId())
                        .passengerId(request.getPassengerId())
                        .passengerName(request.getPassengerName())
                        .day(request.getDay())
                        .month(request.getMonth())
                        .year(request.getYear())
                        .driverRating(request.getDriverRating())
                        .build();
                ratingsRepository.save(rating);
            }
            return new ApiResponse<>(null, false, "SUCCESS");
        } catch (Exception e) {
            return new ApiResponse<>(null, false, "UNSUCCESSFUL");
        }
    }
    @Override
    public ApiResponse<String> ratePassenger(RatingRequest request) {
        try {
            Ratings existingRating = ratingsRepository.findByRideId(request.getRideId());
            if(Objects.nonNull(existingRating))
            {
                existingRating.setPassengerRating(request.getPassengerRating());
                existingRating.setDriverName(request.getDriverName());
                existingRating.setDriverId(request.getDriverId());
            }
            else
            {
                Ratings rating = Ratings.builder()
                        .rideId(request.getRideId())
                        .driverId(request.getDriverId())
                        .driverName(request.getDriverName())
                        .day(request.getDay())
                        .month(request.getMonth())
                        .year(request.getYear())
                        .passengerRating(request.getPassengerRating())
                        .build();
                ratingsRepository.save(rating);
            }
            return new ApiResponse<>(null, false, "SUCCESS");
        } catch (Exception e) {
            return new ApiResponse<>(null, false, "UNSUCCESSFUL");
        }
    }



    @Override
    public ApiResponse<Double> getPassengerAggregateRating(Integer passengerId) {
        try {
            List<Ratings> passengerRatings = ratingsRepository.findAllByPassengerId(passengerId);
            int sumRatings=0;
            for(Ratings rating:passengerRatings){
                sumRatings+=rating.getPassengerRating();
            }
            Integer totalRatings = passengerRatings.size();
            Integer aggregateRatings=sumRatings/totalRatings;
            return new ApiResponse(aggregateRatings, true, "SUCCESS");

        }
        catch (Exception e) {
            return new ApiResponse(null, false, "UNSUCCESSFUL");
        }
    }
    @Override
    public ApiResponse<Double> getDriverAggregateRating(Integer driverId) {
        try {
            List<Ratings> passengerRatings = ratingsRepository.findAllByDriverId(driverId);
            int sumRatings=0;
            for(Ratings rating:passengerRatings){
                sumRatings+=rating.getDriverRating();
            }
            Integer totalRatings = passengerRatings.size();
            Integer aggregateRatings=sumRatings/totalRatings;
            return new ApiResponse(aggregateRatings, true, "SUCCESS");

        }
        catch (Exception e) {
            return new ApiResponse(null, false, "UNSUCCESSFUL");
        }
    }


}
