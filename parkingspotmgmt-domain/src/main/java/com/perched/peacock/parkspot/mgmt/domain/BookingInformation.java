package com.perched.peacock.parkspot.mgmt.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "BookingInformation")
@Table(name = "BOOKING_INFORMATION")
public class BookingInformation {
    @Id
    @SequenceGenerator(name = "bookingSeqGen", sequenceName = "seq_id_booking", initialValue = 10000, allocationSize = 1)
    @GeneratedValue(generator = "bookingSeqGen")
    @Column(name = "BOOKING_ID")
    private Long bookingId;
    @OneToOne
    @JoinColumn(name = "SPOT_ID")
    private ParkingSpot parkingSpotId;
    @OneToOne
    @JoinColumn(name = "VEHICLE_ID")
    private Vehicle vehicleId;

    @Column(name = "BOOKING_TIME")
    private Date bookingTime;
    @Column(name = "EXIT_TIME")
    private Date exitTime;
    @Column(name = "ENTRY_TIME")
    private Date entryTime;

    @Column(name = "AMOUNT_PAID")
    private Double amountPaid;

}
