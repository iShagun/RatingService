package com.project.ratingsystem.service;

import com.project.ratingsystem.request.RatingRequest;
import com.project.ratingsystem.response.ApiResponse;

public interface IRatingService {
    ApiResponse<String> rateDriver(RatingRequest request);
    ApiResponse<String> ratePassenger(RatingRequest request);

    ApiResponse<Double> getDriverAggregateRating(Integer driverId);
    ApiResponse<Double> getPassengerAggregateRating(Integer passengerId);
}
