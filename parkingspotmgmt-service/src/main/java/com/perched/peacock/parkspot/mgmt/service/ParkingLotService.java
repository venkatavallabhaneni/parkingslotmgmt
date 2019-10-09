package com.perched.peacock.parkspot.mgmt.service;

import com.perched.peacock.parkspot.mgmt.domain.ParkingLot;
import com.perched.peacock.parkspot.mgmt.domain.ParkingSpot;
import com.perched.peacock.parkspot.mgmt.domain.VehicleType;

import java.util.List;
import java.util.Optional;

public interface ParkingLotService {

    Optional<ParkingLot> findByLotId(Long lotId);

    Optional<ParkingLot> findByLotName(String lotName);

    Optional<List<ParkingSpot>> findVacantParkingSpotsByVehicleTypeAndLotId(VehicleType vehicleType, Long lotId);
}