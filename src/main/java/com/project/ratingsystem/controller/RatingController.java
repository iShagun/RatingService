package com.project.ratingsystem.controller;

import com.project.ratingsystem.request.RatingRequest;
import com.project.ratingsystem.response.ApiResponse;
import com.project.ratingsystem.service.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * by Shagun
 */

@RestController
@RequestMapping(value = "/rating", produces = MediaType.APPLICATION_JSON_VALUE)
public class RatingController {

    @Autowired
    private IRatingService RatingSystemService;

    @RequestMapping(value = "/passengerRatesDriver", method = RequestMethod.POST)
    public ApiResponse<String> rateDriver(@RequestBody RatingRequest request) {
        return RatingSystemService.rateDriver(request);
    }

    @RequestMapping(value = "/driverRatesPassenger", method = RequestMethod.POST)
    public ApiResponse<String> ratePassenger(@RequestBody RatingRequest request) {
        return RatingSystemService.ratePassenger(request);
    }

    @RequestMapping(value = "/getAggregateDriverRating", method = RequestMethod.GET)
    public ApiResponse<Double> getDriverAggregateRating(@RequestParam("driver_id") Integer driverId) {
        return RatingSystemService.getDriverAggregateRating(driverId);
    }

    @RequestMapping(value = "/getAggregatePassengerRating", method = RequestMethod.GET)
    public ApiResponse<Double> getPassengerAggregateRating(@RequestParam("passenger_id") Integer passengerId) {
        return RatingSystemService.getPassengerAggregateRating(passengerId);
    }
}
