package com.perched.peacock.parkspot.mgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class BookingQuery {
    private VehicleDto vehicleDto;
    private Long lotId;
}
