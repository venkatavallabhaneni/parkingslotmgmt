package com.perched.peacock.parkspot.mgmt.service;

import com.perched.peacock.parkspot.mgmt.dto.ParkingLotDto;
import com.perched.peacock.parkspot.mgmt.dto.BookingInformationDto;
import com.perched.peacock.parkspot.mgmt.dto.VehicleDto;

import java.util.List;

public interface ParkingLotService {

    ParkingLotDto findByLotId(Long lotId);

    List<ParkingLotDto> findAll();

    List<ParkingLotDto> create(List<ParkingLotDto> parkingLots);

    boolean delete(ParkingLotDto parkingLot);

    ParkingLotDto findByLotName(String lotName);



}
