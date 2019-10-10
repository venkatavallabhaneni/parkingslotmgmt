package com.perched.peacock.parkspot.mgmt.controller;

import com.perched.peacock.parkspot.mgmt.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/parkinglot")
public class ParkingLotController {

    @Autowired
    private ParkingLotService parkingLotService;


}
