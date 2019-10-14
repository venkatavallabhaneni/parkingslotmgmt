package com.perched.peacock.parkspot.mgmt.service;

import com.perched.peacock.parkspot.mgmt.commons.BookingMapper;
import com.perched.peacock.parkspot.mgmt.commons.ParkingSpotMapper;
import com.perched.peacock.parkspot.mgmt.commons.Utils;
import com.perched.peacock.parkspot.mgmt.commons.VehicleMapper;
import com.perched.peacock.parkspot.mgmt.dao.BookingInformationDao;
import com.perched.peacock.parkspot.mgmt.dao.ParkingSpotDao;
import com.perched.peacock.parkspot.mgmt.dao.VehicleDao;
import com.perched.peacock.parkspot.mgmt.domain.*;
import com.perched.peacock.parkspot.mgmt.dto.BookingInformationDto;
import com.perched.peacock.parkspot.mgmt.dto.ParkingSpotDto;
import com.perched.peacock.parkspot.mgmt.dto.VehicleDto;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ParkingSpotServiceImpl implements ParkingSpotService {

    private ParkingSpotDao parkingSpotDao;

    private VehicleDao vehicleDao;

    private BookingInformationDao bookingInformationDao;


    private BookingMapper bookingMapper = Mappers.getMapper(BookingMapper.class);
    private ParkingSpotMapper mapper = Mappers.getMapper(ParkingSpotMapper.class);
    private VehicleMapper vehicleMapper = Mappers.getMapper(VehicleMapper.class);

    @Autowired
    public ParkingSpotServiceImpl(ParkingSpotDao parkingSpotDao, VehicleDao vehicleDao, BookingInformationDao bookingInformationDao) {
        this.parkingSpotDao = parkingSpotDao;
        this.vehicleDao = vehicleDao;
        this.bookingInformationDao = bookingInformationDao;
    }

    @Override
    public ParkingSpotDto findBySpotId(Long spotId) {

        Optional<ParkingSpot> spot = parkingSpotDao.findById(spotId);

        if (spot.isPresent()) {
            return mapper.mapEntity2Dto(spot.get());
        }

        return null;
    }

    @Override
    public List<ParkingSpotDto> create(List<ParkingSpotDto> parkingSpots) {
        Iterable<ParkingSpot> spots = parkingSpotDao.saveAll(mapper.mapDtos2Entities(parkingSpots));

        return mapper.mapEntities2Dtos(StreamSupport.stream(spots.spliterator(), true).collect(Collectors.toList()));
    }

    @Override
    public boolean delete(ParkingSpotDto parkingSpot) {
        parkingSpotDao.delete(mapper.mapDto2Entity(parkingSpot));
        return true;
    }

    @Override
    public List<ParkingSpotDto> findAllByLotId(Long lotId) {
        List<ParkingSpot> spots = parkingSpotDao.findByParkingLotId(lotId);
        return mapper.mapEntities2Dtos(spots);
    }

    @Override
    public List<ParkingSpotDto> findVacantParkingSpotsByLotIdAndVehicleType(Long lotId, String vehicleType) {

        Optional<List<ParkingSpot>> spots = Optional.empty();

        String spotType = this.getSpotTypeGivenVehicleType(vehicleType);

        if (StringUtils.isEmpty(spotType)) {
            spots = parkingSpotDao.findVacantParkingSpotsByParkingLotIdAndOccupiedIsFalse(lotId);
        } else {

            spots = parkingSpotDao.findVacantParkingSpotsByParkingLotIdAndParkingSpotTypeAndOccupiedIsFalse(lotId, SpotType.valueOf(spotType));
        }

        if (spots.isPresent()) {

            return mapper.mapEntities2Dtos(spots.get());
        }

        return Collections.emptyList();
    }

    @Override
    public BookingInformationDto bookASpotForAGivenVehicleAndLotId(VehicleDto vehicle, Long lotId) {


        List<ParkingSpotDto> spotsVacant = this.findVacantParkingSpotsByLotIdAndVehicleType(lotId, vehicle.getVehicleType());
        if (spotsVacant == null || spotsVacant.isEmpty()) {
            return null;
        }
        ParkingSpotDto firstVacantSpot = spotsVacant.get(0);
        firstVacantSpot.setOccupied(true);


        List<ParkingSpotDto> toBeUpdatedList = new ArrayList<>(1);
        toBeUpdatedList.add(firstVacantSpot);
        List<ParkingSpotDto> updatedList = this.create(toBeUpdatedList);

        BookingInformation aBookingInformation = new BookingInformation();
        aBookingInformation.setBookingTime(new Date());
        aBookingInformation.setExitTime(null);
        aBookingInformation.setEntryTime(new Date());
        aBookingInformation.setParkingSpotId(mapper.mapDto2Entity(updatedList.get(0)));

        Vehicle linkedVehicle = null;
        Optional<Vehicle> vehicleEntity = vehicleDao.findByVehicleNumber(vehicle.getVehicleNumber());
        if (!vehicleEntity.isPresent()) {
            linkedVehicle = vehicleDao.save(vehicleMapper.mapDto2Entity(vehicle));
            aBookingInformation.setVehicleId(linkedVehicle);
        } else {
            aBookingInformation.setVehicleId(vehicleEntity.get());
            linkedVehicle = vehicleEntity.get();
        }


        BookingInformation bookingInformation = bookingInformationDao.save(aBookingInformation);
        bookingInformation.setVehicleId(linkedVehicle);
        return bookingMapper.mapEntity2Dto(bookingInformation);
    }

    @Override
    public BookingInformationDto vacateASpotForGivenRegNumber(String vehicleRegistrationNumber) {
        Optional<Vehicle> vehicle = vehicleDao.findByVehicleNumber(vehicleRegistrationNumber);
        if (!vehicle.isPresent()) {
            return null;
        }
        BookingInformation information = bookingInformationDao.findByVehicleIdIdAndExitTimeIsNull(vehicle.get().getId());
        information.setExitTime(new Date());
        Double price =Utils.getTotalCost(information.getParkingSpotId().getPrice(), information.getExitTime(), information.getEntryTime());
        information.setAmountPaid(price);
        BookingInformation vacatedDetails = bookingInformationDao.save(information);
        return bookingMapper.mapEntity2Dto(vacatedDetails);
    }

    protected String getSpotTypeGivenVehicleType(String vehicleType) {

        if (StringUtils.isEmpty(vehicleType)) {
            return "";
        }

        if (VehicleType.MOTORCYCLE.equals(VehicleType.valueOf(vehicleType))) {

            return SpotType.SMALL.name();
        }
        if (VehicleType.CAR.equals(VehicleType.valueOf(vehicleType))) {
            return SpotType.MEDIUM.name();
        }
        if (VehicleType.BUS.equals(VehicleType.valueOf(vehicleType))) {
            return SpotType.LARGE.name();
        }
        if (VehicleType.TRUCK.equals(VehicleType.valueOf(vehicleType))) {
            return SpotType.XTRALARGE.name();
        }
        if (VehicleType.AUTO.equals(VehicleType.valueOf(vehicleType))) {
            return SpotType.MEDIUM.name();
        }
        return SpotType.MEDIUM.name();
    }


}
