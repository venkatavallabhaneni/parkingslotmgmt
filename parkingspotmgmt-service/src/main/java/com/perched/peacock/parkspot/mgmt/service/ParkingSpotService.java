package com.perched.peacock.parkspot.mgmt.service;

import com.perched.peacock.parkspot.mgmt.dto.BookingInformationDto;
import com.perched.peacock.parkspot.mgmt.dto.ParkingSpotDto;
import com.perched.peacock.parkspot.mgmt.dto.VehicleDto;

import java.util.List;

public interface ParkingSpotService {

    ParkingSpotDto findBySpotId(Long spotId);

    List<ParkingSpotDto> findAllByLotId(Long lotId);


    List<ParkingSpotDto> create(List<ParkingSpotDto> parkingSpots);

    boolean delete(ParkingSpotDto parkingSpot);

    List<ParkingSpotDto> findVacantParkingSpotsByLotIdAndVehicleType(Long lotId, String vehicleType);

    BookingInformationDto bookASpotForAGivenVehicleAndLotId(VehicleDto vehicle,Long lotId);

    BookingInformationDto vacateASpotForGivenRegNumber(String vehicleRegsitrationNumber);

}
