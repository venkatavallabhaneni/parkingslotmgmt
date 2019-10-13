package com.perched.peacock.parkspot.mgmt.controller;

import com.perched.peacock.parkspot.mgmt.dto.*;
import com.perched.peacock.parkspot.mgmt.service.ParkingSpotService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/parkingspot")
public class ParkingSpotController {

    private ParkingSpotService parkingSpotService;

    @Autowired
    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }


    @PreAuthorize("#oauth2.hasScope('read')")
    @GetMapping(value = "/availability/{lotId}", headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "get un occupied parking spots in a  given lot for a vehicle size", notes = "An operation to get un occupied parking spots in a  given lot and vehicle type ,<br>allowed vehicle types are: <ul><li>CAR</li><li>BUS</li<li>TRUCK</li><li>MOTORCYCLE</li><li>AUTO</li></ul>")
    public List<ParkingSpotDto> getAvailableSpotsInaLot(@PathVariable(value = "lotId") Long lotId, @RequestParam(value = "vehicleType", required = false) String vehicleType) {

        List<ParkingSpotDto> vacantParkingSpots = parkingSpotService.findVacantParkingSpotsByLotIdAndVehicleType(lotId, vehicleType);

        return vacantParkingSpots;
    }

    @PreAuthorize("#oauth2.hasScope('trust')")
    @PostMapping(value = "/book", headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "book a spot for a given vehicle and lot", notes = "An operation book a spot for a given vehicle and lot, all fields are manadatory except id, ")
    public BookingInformationDto bookAParkingSpotForAVehicle(@RequestBody BookingQuery query) {
        query.getVehicleDto().setId(null);
        BookingInformationDto bookingInformationDto = parkingSpotService.bookASpotForAGivenVehicleAndLotId(query.getVehicleDto(), query.getLotId());

        return bookingInformationDto;
    }

    @PreAuthorize("#oauth2.hasScope('trust')")
    @PostMapping(value = "/vacate/{registrationNumber}", headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "vacate a spot for a given vehicle registration number", notes = "An operation to vacate a spot for a given vehicle registration number")
    public BookingInformationDto vacateASpot(@PathVariable(value = "registrationNumber") String registrationNumber) {

        BookingInformationDto information = parkingSpotService.vacateASpotForGivenRegNumber(registrationNumber);
        return information;
    }

    @PreAuthorize("#oauth2.hasScope('admin')")
    @PostMapping(headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Add parking Spots to a parking lot", notes = "An operation to Add parking Spots to a parking lot, Parking lotId and Price is mandatory to create parking spot")
    public List<ParkingSpotDto> establishParkingSpots(@RequestBody List<ParkingSpotDto> spots) {

        spots.forEach(aSpot -> {
            aSpot.setParkingSpotId(null);
            aSpot.setOccupied(false);
        });

        List<ParkingSpotDto> parkingSpots = parkingSpotService.create(spots);
        return parkingSpots;
    }
}
