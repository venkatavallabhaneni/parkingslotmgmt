package com.perched.peacock.parkspot.mgmt.service;

import com.perched.peacock.parkspot.mgmt.domain.BookingInformation;
import com.perched.peacock.parkspot.mgmt.dto.BookingInformationDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingInformationService {

    List<BookingInformationDto> findBookingInfoByVehicleIdVehicleNumber(String regNumber);

    List<BookingInformationDto> findBookingInfoByParkingSpotIdParkingSpotId(Long spotId);

    List<BookingInformationDto> findBookingInfoByBookingTime(String bookingTime);
}
