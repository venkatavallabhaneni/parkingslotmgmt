package com.perched.peacock.parkspot.mgmt.service;

import com.perched.peacock.parkspot.mgmt.domain.ParkingLot;
import com.perched.peacock.parkspot.mgmt.domain.ParkingSpot;
import com.perched.peacock.parkspot.mgmt.domain.VehicleType;
import com.perched.peacock.parkspot.mgmt.dto.ParkingLotDto;
import com.perched.peacock.parkspot.mgmt.dto.ParkingSpotDto;

import java.util.List;
import java.util.Optional;

public interface ParkingLotService {

    Optional<ParkingLotDto> findByLotId(Long lotId);

    List<ParkingLotDto> findAll();

    List<ParkingLotDto> create(List<ParkingLotDto> parkingLots);

    boolean delete(ParkingLotDto parkingLot);

    Optional<ParkingLotDto> findByLotName(String lotName);

    Optional<List<ParkingSpotDto>> findVacantParkingSpotsByVehicleTypeAndLotId(VehicleType vehicleType, Long lotId);
}
