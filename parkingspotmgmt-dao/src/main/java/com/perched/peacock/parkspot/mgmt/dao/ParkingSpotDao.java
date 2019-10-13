package com.perched.peacock.parkspot.mgmt.dao;

import com.perched.peacock.parkspot.mgmt.domain.ParkingLot;
import com.perched.peacock.parkspot.mgmt.domain.ParkingSpot;
import com.perched.peacock.parkspot.mgmt.domain.SpotType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ParkingSpotDao extends CrudRepository<ParkingSpot, Number> {

    ParkingLot findByParkingSpotIdAndParkingLotId(Long lotId,Long spotId);

    Optional<List<ParkingSpot>> findVacantParkingSpotsByParkingLotIdAndParkingSpotTypeAndOccupiedIsFalse(Long lotId, SpotType spotType);

    Optional<List<ParkingSpot>> findVacantParkingSpotsByParkingLotIdAndOccupiedIsFalse(Long lotId);



}
