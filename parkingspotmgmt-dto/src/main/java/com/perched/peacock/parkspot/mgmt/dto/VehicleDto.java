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
public class VehicleDto {


    @ApiModelProperty(notes = "vehicle id", example = "123")
    private Long id;

    @ApiModelProperty(notes = "vehicle registration number", example = "KA05ML3011")
    private String vehicleNumber;

    @ApiModelProperty(notes = "Approximate weight of the vehicle in KG's", example = "200")
    private Integer vehicleWeight;


    @ApiModelProperty(notes = "Vehicle type", example = "Bus/Van")
    private String vehicleType;

    @ApiModelProperty(notes = "Vehicle owner name", example = "vallabhaneni")
    private String ownerName;


}
