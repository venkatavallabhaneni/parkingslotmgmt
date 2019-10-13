package com.perched.peacock.parkspot.mgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Period;
import java.util.Date;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class BookingInformationDto {

    private ParkingSpotDto parkingSpot;
    private VehicleDto vehicleDto;
    private Date bookingTime;
    private Date exitTime;
    private Date entryTime;
    private Double amountPaid;
    private String bookingId;



}
