package com.perched.peacock.parkspot.mgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "ParkingSpot")
@Table(name = "PARKINGSPOTS")
@ApiModel(description = "A Parking Spot in the Lot")
public class ParkingSpot implements Serializable {

    @Id
    @SequenceGenerator(name = "parkingspotSeqGen", sequenceName = "seq_id_parkingspot", initialValue = 5, allocationSize = 1)
    @GeneratedValue(generator = "parkingspotSeqGen")

    @ApiModelProperty(notes = "A spot ID", example = "1234")
    @Column(name = "SPOT_ID")
    private Long parkingSpotId;

    @ApiModelProperty(notes = "A spot type or size of the spot", example = "MEDIUAM/LARGE/XTRALARGE/SMALL")
    @Column(name = "SPOT_TYPE")
    @Enumerated(EnumType.STRING)
    private SpotType parkingSpotType;

    @Column(name = "LOT_ID")
    private Long parkingLotId;

    @ApiModelProperty(notes = "spot occupancy status", example = "true/false")
    @Column(name = "SPOT_OCCUPIED")
    private boolean occupied;

    @Column(name = "SPOT_PRICE")
    private Double price;




}
