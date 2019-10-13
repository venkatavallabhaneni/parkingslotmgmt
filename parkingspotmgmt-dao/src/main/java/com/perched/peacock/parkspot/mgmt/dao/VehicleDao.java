package com.perched.peacock.parkspot.mgmt.dao;

import com.perched.peacock.parkspot.mgmt.domain.ParkingLot;
import com.perched.peacock.parkspot.mgmt.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VehicleDao extends CrudRepository<Vehicle, Number> {

   Optional<Vehicle> findByVehicleNumber(String vehicleRegNumber);


}
