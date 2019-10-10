package com.perched.peacock.parkspot.mgmt.domain;

import lombok.Data;

@Data
public class SpotBooking {

    private Vehicle vehicle;
    private String lotName;
    private Long lotId;
}
