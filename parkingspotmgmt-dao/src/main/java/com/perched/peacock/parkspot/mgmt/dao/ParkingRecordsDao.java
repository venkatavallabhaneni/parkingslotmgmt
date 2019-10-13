package com.perched.peacock.parkspot.mgmt.dao;

import com.perched.peacock.parkspot.mgmt.domain.BookingInformation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParkingRecordsDao extends CrudRepository<BookingInformation, Number> {

    List<BookingInformation> findByVehicleIdVehicleNumber(String vehicleRegNumber);

    List<BookingInformation> findByParkingSpotIdParkingSpotId(Long spotId);

    @Query(value = "select * from BOOKING_INFORMATION b where to_char(b.BOOKING_TIME,'DD-MM-YYYY')=:bookingTime", nativeQuery = true)
    List<BookingInformation> findByBookingTime(@Param(value = "bookingTime") String bookingTime);
}
