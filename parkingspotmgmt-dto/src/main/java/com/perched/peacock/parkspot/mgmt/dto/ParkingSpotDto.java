package com.perched.peacock.parkspot.mgmt.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpotDto {

    @ApiModelProperty(notes = "A spot ID", example = "1234")
    private Long parkingSpotId;

    @ApiModelProperty(notes = "A spot type or size of the spot", example = "MEDIUAM/LARGE")
    private String parkingSpotType;

    @ApiModelProperty(notes = "A parking Lot Id", example = "1234")
    private Long parkingLotId;

    @ApiModelProperty(notes = "spot occupancy status", example = "true/false")
    private boolean occupied;

    @ApiModelProperty(notes = "Price per hour", example = "2")
    private Double price;

}
