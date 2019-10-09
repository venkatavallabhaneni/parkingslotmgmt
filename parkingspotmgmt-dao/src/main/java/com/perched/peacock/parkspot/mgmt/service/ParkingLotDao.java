package com.perched.peacock.parkspot.mgmt.service;

import com.perched.peacock.parkspot.mgmt.domain.ParkingLot;
import com.perched.peacock.parkspot.mgmt.domain.ParkingSpot;
import com.perched.peacock.parkspot.mgmt.domain.VehicleType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ParkingLotDao extends CrudRepository<ParkingLot, Number> {

    Optional<ParkingLot> findById(Long lotId);

    Optional<ParkingLot> findByName(String lotName);

    Optional<List<ParkingSpot>> findVacantParkingSpotsByVehicleTypeAndLotId(VehicleType vehicleType, Long lotId);

}
