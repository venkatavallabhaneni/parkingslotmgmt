package com.perched.peacock.parkspot.mgmt.service;

import com.perched.peacock.parkspot.mgmt.commons.ParkingSpotMapper;
import com.perched.peacock.parkspot.mgmt.dao.BookingInformationDao;
import com.perched.peacock.parkspot.mgmt.dao.ParkingSpotDao;
import com.perched.peacock.parkspot.mgmt.dao.VehicleDao;
import com.perched.peacock.parkspot.mgmt.domain.*;
import com.perched.peacock.parkspot.mgmt.dto.BookingInformationDto;
import com.perched.peacock.parkspot.mgmt.dto.ParkingLotDto;
import com.perched.peacock.parkspot.mgmt.dto.ParkingSpotDto;
import com.perched.peacock.parkspot.mgmt.dto.VehicleDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class ParkingSpotServiceImplTest {

    Logger logger = LoggerFactory.getLogger(ParkingSpotServiceImplTest.class);

    private ParkingSpotMapper mapper = null;

    @Mock
    private ParkingSpotDao daoMock;
    @Mock
    private VehicleDao vehicleDao;
    @Mock
    private BookingInformationDao bookingInformationDao;


    @InjectMocks
    private ParkingSpotServiceImpl serviceMock;

    private ParkingSpot aParkingSpot = null;

    PodamFactory factory = null;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        aParkingSpot = mock(ParkingSpot.class);
        mapper = Mappers.getMapper(ParkingSpotMapper.class);
        factory = new PodamFactoryImpl();
    }

    @Test
    public void test_Given_ParkingSpotObject_When_Create_Return_ParkingSpot() {

        ParkingSpot parkingLot = factory.manufacturePojoWithFullData(ParkingSpot.class);
        List<ParkingSpot> list = new ArrayList<>();
        list.add(parkingLot);

        doReturn(list).when(daoMock).saveAll(list);

        List<ParkingSpotDto> result = serviceMock.create(mapper.mapEntities2Dtos(list));
        Assert.assertEquals(list.size(), result.size());

    }

    @Test
    public void test_Given_SpotId_When_findBySpotId_Return_ParkingSpot() {

        ParkingSpot parkingLot = factory.manufacturePojoWithFullData(ParkingSpot.class);
        parkingLot.setParkingSpotId(123L);

        doReturn(Optional.of(parkingLot)).when(daoMock).findById(any());

        ParkingSpotDto result = serviceMock.findBySpotId(123L);
        Assert.assertEquals(parkingLot.getPrice(), result.getPrice());

    }

    @Test
    public void test_Given_lotId_When_findByLotId_Return_ParkingSpot() {

        ParkingSpot parkingSpot = factory.manufacturePojoWithFullData(ParkingSpot.class);
        parkingSpot.setParkingSpotId(123L);
        parkingSpot.setParkingLotId(234L);
        List<ParkingSpot> spots = new ArrayList<>();
        spots.add(parkingSpot);
        doReturn(spots).when(daoMock).findByParkingLotId(any());

        List<ParkingSpotDto> result = serviceMock.findAllByLotId(234L);
        Assert.assertEquals(result.size(), spots.size());

    }


    @Test
    public void test_Given_parkingSot_When_delete_Return_Boolean() {

        ParkingSpotDto parkingLot = factory.manufacturePojoWithFullData(ParkingSpotDto.class);
        parkingLot.setParkingLotId(123L);
        parkingLot.setParkingSpotType(SpotType.MEDIUM.name());
        boolean result = serviceMock.delete(parkingLot);
        Assert.assertEquals(result, true);

    }

    @Test
    public void test_Given_lotIdandType_When_findVacantParkingSpotsByLotIdAndVehicleType_Return_ParkingSpot() {

        ParkingSpot parkingSpot = factory.manufacturePojoWithFullData(ParkingSpot.class);
        parkingSpot.setParkingSpotId(123L);
        parkingSpot.setParkingLotId(234L);
        parkingSpot.setParkingSpotType(SpotType.MEDIUM);
        List<ParkingSpot> spots = new ArrayList<>();
        spots.add(parkingSpot);
        doReturn(Optional.of(spots)).when(daoMock).findVacantParkingSpotsByParkingLotIdAndParkingSpotTypeAndOccupiedIsFalse(any(), any());

        List<ParkingSpotDto> result = serviceMock.findVacantParkingSpotsByLotIdAndVehicleType(234L, VehicleType.CAR.name());
        Assert.assertEquals(result.size(), spots.size());

    }

    @Test
    public void test_Given_vehicleNumber_When_vacateASpotForGivenRegNumber_Return_BookingInformationDto() {

        BookingInformation aBookingInformation = factory.manufacturePojoWithFullData(BookingInformation.class);
        Vehicle aVehicle = factory.manufacturePojoWithFullData(Vehicle.class);
        aVehicle.setVehicleNumber("KA04ML222");
        aBookingInformation.setVehicleId(aVehicle);


        doReturn(Optional.of(aVehicle)).when(vehicleDao).findByVehicleNumber(any());


        doReturn(aBookingInformation).when(bookingInformationDao).findByVehicleIdIdAndExitTimeIsNull(any());

        doReturn(aBookingInformation).when(bookingInformationDao).save(any());

        BookingInformationDto result = serviceMock.vacateASpotForGivenRegNumber("KA04ML222");
        Assert.assertEquals(result.getVehicleDto().getVehicleNumber(), aBookingInformation.getVehicleId().getVehicleNumber());

    }


}
