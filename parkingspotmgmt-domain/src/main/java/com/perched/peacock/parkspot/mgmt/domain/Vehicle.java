package com.perched.peacock.parkspot.mgmt.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "Vehicle")
@Table(name = "VEHICLES")
public class Vehicle implements Serializable {

    @Id
    @SequenceGenerator(name = "vehicleSeqGen", sequenceName = "seq_id_vehicle", initialValue = 5, allocationSize = 1)
    @GeneratedValue(generator = "vehicleSeqGen")
    @Column(name = "ID")
    @ApiModelProperty(notes = "vehicle id", example = "123")
    private Long id;
    @ApiModelProperty(notes = "vehicle registration number", example = "KA05ML3011")
    @Column(name = "REG_NUMBER")
    private String vehicleNumber;

    @ApiModelProperty(notes = "Approximate weight of the vehicle in KG's", example = "200")
    @Column(name = "WEIGHT")
    private Integer vehicleWeight;

    @Column(name = "VEHICLE_TYPE")
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Column(name = "VEHICLE_OWNER")
    private String ownerName;
}
