package com.perched.peacock.parkspot.mgmt.dao;

import com.perched.peacock.parkspot.mgmt.domain.BookingInformation;
import com.perched.peacock.parkspot.mgmt.domain.ParkingLot;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookingInformationDao extends CrudRepository<BookingInformation, Number> {

    BookingInformation findByVehicleIdIdAndExitTimeIsNull(Long vehicleId);
}
