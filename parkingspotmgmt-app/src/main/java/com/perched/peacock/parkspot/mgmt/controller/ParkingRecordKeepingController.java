package com.perched.peacock.parkspot.mgmt.controller;

import com.perched.peacock.parkspot.mgmt.dto.BookingInformationDto;
import com.perched.peacock.parkspot.mgmt.dto.ParkingLotDto;
import com.perched.peacock.parkspot.mgmt.service.BookingInformationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/parkinglot/records")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ParkingRecordKeepingController {


    private BookingInformationService bookingInformationService;

    @Autowired
    public ParkingRecordKeepingController(BookingInformationService bookingInformationService) {
        this.bookingInformationService = bookingInformationService;
    }


    @PreAuthorize("#oauth2.hasScope('admin')")
    @GetMapping(value = "/regnumber/{registrationNumber}", headers = "Accept=application/json", produces = "application/json")
    @ApiOperation(value = "get all booking information by vehicle registration number", notes = "An operation to  get booking information by vehicle registration number")
    @ResponseBody
    public List<BookingInformationDto> findBookingInfoByVehicleNumber(@PathVariable(value = "registrationNumber") String registrationNumber) {
        return bookingInformationService.findBookingInfoByVehicleIdVehicleNumber(registrationNumber);
    }

    @PreAuthorize("#oauth2.hasScope('admin')")
    @GetMapping(value = "/spot/{spotId}", headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Get all booking information by spotId", notes = "An operation to Get all booking information by spotId")
    public List<BookingInformationDto> findBookingInformationBySpotId(@PathVariable(value = "spotId") Long spotId) {
        return bookingInformationService.findBookingInfoByParkingSpotIdParkingSpotId(spotId);

    }

    @PreAuthorize("#oauth2.hasScope('admin')")
    @GetMapping(value = "/date/{bookingDate}", headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "get all booking information by booking time (DD-MM-yyyy)", notes = "An operation to all booking information by booking time(DD-MM-yyyy, 28-02-2019)")
    public List<BookingInformationDto> findBookingInfoByBookingTime(@PathVariable(value = "bookingDate") String bookingDate) {
        return bookingInformationService.findBookingInfoByBookingTime(bookingDate);

    }

}
