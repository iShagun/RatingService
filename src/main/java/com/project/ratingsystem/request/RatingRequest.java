package com.project.ratingsystem.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RatingRequest {
    private Integer rideId;
    private Integer passengerId;
    private String  passengerName;
    private Integer driverId;
    private String  driverName;
    private Integer day;
    private Integer month;
    private Integer year;
    private Integer passengerRating;
    private Integer driverRating;
}
