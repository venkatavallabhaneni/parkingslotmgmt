package com.perched.peacock.parkspot.mgmt.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "ParkingSpot")
@Table(name = "PARKINGSPOTS")
public class ParkingSpot implements Serializable {

    @Id
    @SequenceGenerator(name = "parkingspotSeqGen", sequenceName = "seq_id_parkingspot", initialValue = 5, allocationSize = 100)
    @GeneratedValue(generator = "parkingspotSeqGen")

    @Column(name = "SPOT_ID")
    private Long parkingSpotId;

    @Column(name = "SPOT_TYPE")
    @Enumerated(EnumType.STRING)
    private SpotType parkingSpotType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOT_ID")
    private ParkingLot parkingLotId;

    @Column(name = "SPOT_OCCUPIED")
    private boolean occupied;

    @OneToOne(mappedBy = "parkingSpot", cascade = CascadeType.ALL)
    private Vehicle vehicle;


}
