package com.perched.peacock.parkspot.mgmt.controller;

import com.perched.peacock.parkspot.mgmt.domain.*;
import com.perched.peacock.parkspot.mgmt.service.ParkingLotService;
import com.perched.peacock.parkspot.mgmt.service.ParkingSpotService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/parkingspot")
public class ParkingSpotController {

    private ParkingSpotService parkingSpotService;

    @Autowired
    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }


    @GetMapping(value = "/{lotName}", headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "get available parking spots in a  given lot", notes = "An operation to get available parking spots in a  given lot")
    public List<Long> getAvailableSpotsInaLot(@PathVariable(value = "lotName") String lotName) {

        List<Long> spotNumbers = new ArrayList<>();
        return spotNumbers;
    }

    @PostMapping(value = "/book", headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "book a slot", notes = "An operation to book a spot")
    public ParkingRecord allotASpotInaGivenLot(@RequestBody SpotBooking spotBooking) {
        return new ParkingRecord();
    }

    @PostMapping(value = "/vacate/{lotName}/{registrationNumber}", headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "vacate a spot", notes = "An operation to vacate a spot")
    public ParkingRecord vacateASpot(@PathVariable(value = "lotName") String lotName, @PathVariable(value = "registrationNumber") String registrationNumber) {
        return new ParkingRecord();
    }
}
