package com.perched.peacock.parkspot.mgmt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity(name = "ParkingLot")
@Table(name = "PARKINGLOTS")
@ApiModel(description = "A Parking Lot or an multi level parking premises")
public class ParkingLot implements Serializable {

    @Id
    @SequenceGenerator(name = "parkinglotSeqGen", sequenceName = "seq_id_parkinglot", initialValue = 5, allocationSize = 100)
    @GeneratedValue(generator = "parkinglotSeqGen")

    @ApiModelProperty(notes = "A lot ID", example = "1234")
    @Column(name = "LOT_ID")
    private Long id;
    @ApiModelProperty(notes = "Lot name or parking place name", example = "VOYAGER")
    @Column(name = "LOT_NAME")
    private String name;

    @OneToMany(mappedBy = "parkingLotId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParkingSpot> parkingSpots;


}
