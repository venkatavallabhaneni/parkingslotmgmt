package com.perched.peacock.parkspot.mgmt.service;

import com.perched.peacock.parkspot.mgmt.dao.ParkingLotDao;
import com.perched.peacock.parkspot.mgmt.domain.ParkingLot;
import com.perched.peacock.parkspot.mgmt.domain.ParkingSpot;
import com.perched.peacock.parkspot.mgmt.domain.VehicleType;
import com.perched.peacock.parkspot.mgmt.dto.ParkingLotDto;
import com.perched.peacock.parkspot.mgmt.dto.ParkingSpotDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ParkingLotServiceImpl implements ParkingLotService {

    @Autowired
    private ParkingLotDao parkingLotDao;

    @Override
    public Optional<ParkingLotDto> findByLotId(Long lotId) {
        return Optional.empty();
    }

    @Override
    public Optional<ParkingLotDto> findByLotName(String lotName) {
        return Optional.empty();
    }

    @Override
    public List<ParkingLotDto> findAll() {
        return Collections.emptyList();
    }

    @Override
    public Optional<List<ParkingSpotDto>> findVacantParkingSpotsByVehicleTypeAndLotId(VehicleType vehicleType, Long lotId) {
        return Optional.empty();
    }

    @Override
    public List<ParkingLotDto> create(List<ParkingLotDto> parkingLots) {
        return Collections.emptyList();
    }

    @Override
    public boolean delete(ParkingLotDto parkingLot) {
        return false;
    }
}
