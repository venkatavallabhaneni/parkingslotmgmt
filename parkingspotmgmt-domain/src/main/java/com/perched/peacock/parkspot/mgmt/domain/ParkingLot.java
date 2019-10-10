package com.perched.peacock.parkspot.mgmt.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity(name = "ParkingLot")
@Table(name = "PARKINGLOTS")
public class ParkingLot implements Serializable {

    @Id
    @SequenceGenerator(name = "parkinglotSeqGen", sequenceName = "seq_id_parkinglot", initialValue = 5, allocationSize = 100)
    @GeneratedValue(generator = "parkinglotSeqGen")

    @Column(name = "LOT_ID")
    private Long id;

    @Column(name = "LOT_NAME")
    private String name;

    @OneToMany(mappedBy = "parkingLotId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParkingSpot> parkingSpots;


}
