package com.perched.peacock.parkspot.mgmt.service;

import com.perched.peacock.parkspot.mgmt.domain.ParkingLot;
import com.perched.peacock.parkspot.mgmt.domain.ParkingSpot;
import com.perched.peacock.parkspot.mgmt.domain.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ParkingLotServiceImpl implements ParkingLotService {

    @Autowired
    private ParkingLotDao myBlogDao;

    @Override
    public Optional<ParkingLot> findByLotId(Long lotId) {
        return Optional.empty();
    }

    @Override
    public Optional<ParkingLot> findByLotName(String lotName) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ParkingSpot>> findVacantParkingSpotsByVehicleTypeAndLotId(VehicleType vehicleType, Long lotId) {
        return Optional.empty();
    }
}
