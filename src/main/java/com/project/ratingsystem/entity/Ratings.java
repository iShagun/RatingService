package com.project.ratingsystem.entity;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ratings")
@Data
@Builder
public class Ratings {

    @Id
    @Column(name = "ride_Id")
    private Integer rideId;

    @Column(name = "passenger_id")
    private Integer passengerId;

    @Column(name = "passenger_name")
    private String passengerName;

    @Column(name = "driver_id")
    private Integer driverId;

    @Column(name = "driver_name")
    private String driverName;

    @Column(name = "driver_rating")
    private Integer driverRating;

    @Column(name = "passenger_rating")
    private Integer passengerRating;

    @Column(name = "day")
    private Integer day;

    @Column(name = "month")
    private Integer month;

    @Column(name = "year")
    private Integer year;
}
