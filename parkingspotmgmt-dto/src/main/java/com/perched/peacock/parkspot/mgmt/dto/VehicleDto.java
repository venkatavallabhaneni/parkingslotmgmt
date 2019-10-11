package com.perched.peacock.parkspot.mgmt.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class VehicleDto {


    @ApiModelProperty(notes = "vehicle id", example = "123")
    private Long id;

    @ApiModelProperty(notes = "vehicle registration number", example = "KA05ML3011")
    private String vehicleNumber;

    @ApiModelProperty(notes = "Approximate weight of the vehicle in KG's", example = "200")
    private Integer vehicleWeight;


    @ApiModelProperty(notes = "Vehicle type", example = "Bus/Van")
    private String vehicleType;

    @ApiModelProperty(notes = "Parking spot in which the vehicle is parked", example = "123")
    private Long parkingSpotId;
}
