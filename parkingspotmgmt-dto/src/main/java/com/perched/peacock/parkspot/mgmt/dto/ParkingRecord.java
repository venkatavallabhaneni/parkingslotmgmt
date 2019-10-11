package com.perched.peacock.parkspot.mgmt.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ParkingRecord {

    private ParkingSpotDto parkingSpot;
    private Date bookingTime;
    private Double costPerHour;
    private Date exitTime;
    private Double totalCost;

}
