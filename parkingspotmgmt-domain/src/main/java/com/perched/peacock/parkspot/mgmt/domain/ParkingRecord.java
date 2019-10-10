package com.perched.peacock.parkspot.mgmt.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ParkingRecord {

    private ParkingSpot parkingSpot;
    private Date bookingTime;
    private Double costPerHour;
    private Date exitTime;
    private Double totalCost;

}
