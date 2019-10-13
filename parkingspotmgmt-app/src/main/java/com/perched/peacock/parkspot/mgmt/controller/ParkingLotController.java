package com.perched.peacock.parkspot.mgmt.controller;

import com.perched.peacock.parkspot.mgmt.dto.ParkingLotDto;
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
    public List<ParkingLotDto> findAllLots() {
        return parkingLotService.findAll();
    }

    @PreAuthorize("#oauth2.hasScope('read')")
    @GetMapping(value = "/{lotName}", headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "get parking lot by name", notes = "An operation to get parking lot by name")
    public ParkingLotDto getLotByName(@PathVariable(value = "lotName") String lotName) {
        ParkingLotDto aLot = parkingLotService.findByLotName(lotName);
        return aLot;
    }

    @PreAuthorize("#oauth2.hasScope('admin')")
    @PostMapping(headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Establish or make a new parking lot", notes = "An operation to Establish or make a new parking lot")
    public List<ParkingLotDto> establishParkingLot(@RequestBody List<ParkingLotDto> lots) {
        return parkingLotService.create(lots);
    }

   @PreAuthorize("#oauth2.hasScope('delete')")
    @ApiOperation(value = "Decomission or unestablish a parking lot", notes = "An operation to Decomission or unestablish a parking lot")
    @DeleteMapping(value = "/{id}", headers = "Accept=application/json", produces = "application/json")
    public boolean delete(@PathVariable(value = "id") Long id) {

        ParkingLotDto aLot = new ParkingLotDto();
        aLot.setId(id);
        return parkingLotService.delete(aLot);

    }


}
