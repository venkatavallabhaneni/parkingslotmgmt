package com.perched.peacock.parkspot.mgmt.controller;

import com.perched.peacock.parkspot.mgmt.domain.ParkingLot;
import com.perched.peacock.parkspot.mgmt.domain.ParkingSpot;
import com.perched.peacock.parkspot.mgmt.service.ParkingLotService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/parkinglot")
public class ParkingLotController {


    private ParkingLotService parkingLotService;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @PreAuthorize("#oauth2.hasScope('read')")
    @GetMapping(headers = "Accept=application/json", produces = "application/json")
    @ApiOperation(value = "get all available parking lots", notes = "An operation to get all available parking lots")
    @ResponseBody
    public List<ParkingLot> findAllLots() {
        return parkingLotService.findAll();
    }

    @PreAuthorize("#oauth2.hasScope('read')")
    @GetMapping(value = "/{lotName}", headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "get parking lot by name", notes = "An operation to get parking lot by name")
    public ParkingLot getLotByName(@PathVariable(value = "lotName") String lotName) {
        Optional<ParkingLot> aLot = parkingLotService.findByLotName(lotName);

        if (aLot.isPresent()) {
            return aLot.get();
        }
        return null;
    }

    @PreAuthorize("#oauth2.hasScope('write')")
    @PostMapping(headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Establish or make a new parking lot", notes = "An operation to Establish or make a new parking lot")
    public List<ParkingLot> establishParkingLot(@RequestBody List<ParkingLot> lots) {
        return parkingLotService.create(lots);
    }

    @PreAuthorize("#oauth2.hasScope('delete')")
    @ApiOperation(value = "Decomission or unestablish a parking lot", notes = "An operation to Decomission or unestablish a parking lot")
    @DeleteMapping(value = "/{id}", headers = "Accept=application/json", produces = "application/json")
    public boolean delete(@PathVariable(value = "id") Long id) {

        ParkingLot aLot = new ParkingLot();
        aLot.setId(id);
        return parkingLotService.delete(aLot);

    }
    @PreAuthorize("#oauth2.hasScope('write')")
    @PostMapping(value = "/addSpots", headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Add parking spots to the existing parking lot", notes = "An operation to Add parking spots to the parking lot")
    public List<ParkingLot> addParkingSpots(@RequestBody ParkingLot aParkingLot) {
        List<ParkingLot> lots = new ArrayList<>();
        lots.add(aParkingLot);
        return parkingLotService.create(lots);
    }


}
