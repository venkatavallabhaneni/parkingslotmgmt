package com.perched.peacock.parkspot.mgmt.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "Vehicle")
@Table(name = "VEHICLES")
public class Vehicle implements Serializable {

    @Id
    @SequenceGenerator(name = "vehicleSeqGen", sequenceName = "seq_id_vehicle", initialValue = 5, allocationSize = 100)
    @GeneratedValue(generator = "vehicleSeqGen")
    private Long id;

    @Column(name = "REG_NUMBER")
    protected String vehicleNumber;

    @Column(name = "REG_NUMBER")
    protected Integer vehicleWeight;

    @Column(name = "VEHICLE_TYPE")
    @Enumerated(EnumType.STRING)
    protected VehicleType vehicleType;

    @OneToOne
    @MapsId
    private ParkingSpot parkingSpot;
}
