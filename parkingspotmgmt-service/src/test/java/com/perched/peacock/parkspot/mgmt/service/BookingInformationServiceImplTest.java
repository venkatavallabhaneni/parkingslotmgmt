package com.perched.peacock.parkspot.mgmt.service;

import com.perched.peacock.parkspot.mgmt.commons.BookingMapper;
import com.perched.peacock.parkspot.mgmt.commons.ParkingLotMapper;
import com.perched.peacock.parkspot.mgmt.dao.ParkingRecordsDao;
import com.perched.peacock.parkspot.mgmt.domain.BookingInformation;
import com.perched.peacock.parkspot.mgmt.domain.ParkingLot;
import com.perched.peacock.parkspot.mgmt.domain.SpotType;
import com.perched.peacock.parkspot.mgmt.domain.VehicleType;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class BookingInformationServiceImplTest {

    Logger logger = LoggerFactory.getLogger(BookingInformationServiceImplTest.class);


    private BookingMapper mapper = null;

    @Mock
    private ParkingRecordsDao daoMock;

    @InjectMocks
    private BookingInformationServiceImpl serviceMock;

    private BookingInformation bookingInformation = null;

    PodamFactory factory = null;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        bookingInformation = mock(BookingInformation.class);
        mapper = Mappers.getMapper(BookingMapper.class);
        factory = new PodamFactoryImpl();
    }


    @Test
    public void test_Given_RegNumber_When_findBookingInfoByVehicleIdVehicleNumber_BookingInformationDto() {

        BookingInformationDto bookingInformationDto = factory.manufacturePojoWithFullData(BookingInformationDto.class);
        bookingInformationDto.setBookingId("123");
        VehicleDto aVehicleDto = factory.manufacturePojoWithFullData(VehicleDto.class);
        aVehicleDto.setVehicleType(VehicleType.CAR.name());
        ParkingSpotDto spotDto = factory.manufacturePojoWithFullData(ParkingSpotDto.class);
        spotDto.setParkingSpotType(SpotType.MEDIUM.name());
        spotDto.setParkingSpotId(123L);
        bookingInformationDto.setParkingSpot(spotDto);
        aVehicleDto.setVehicleNumber("KA2345");
        bookingInformationDto.setVehicleDto(aVehicleDto);
        List<BookingInformationDto> list = new ArrayList<>();
        list.add(bookingInformationDto);

        doReturn(mapper.mapDtos2Entities(list)).when(daoMock).findByVehicleIdVehicleNumber(any());

        List<BookingInformationDto> result = serviceMock.findBookingInfoByVehicleIdVehicleNumber("KA2345");
        Assert.assertEquals(list.size(), result.size());

    }

    @Test
    public void test_Given_SpotId_When_findBookingInfoByParkingSpotIdParkingSpotId_BookingInformationDto() {

        BookingInformationDto bookingInformationDto = factory.manufacturePojoWithFullData(BookingInformationDto.class);
        bookingInformationDto.setBookingId("123");
        VehicleDto aVehicleDto = factory.manufacturePojoWithFullData(VehicleDto.class);
        aVehicleDto.setVehicleType(VehicleType.CAR.name());
        ParkingSpotDto spotDto = factory.manufacturePojoWithFullData(ParkingSpotDto.class);
        spotDto.setParkingSpotType(SpotType.MEDIUM.name());
        spotDto.setParkingSpotId(123L);
        bookingInformationDto.setParkingSpot(spotDto);
        aVehicleDto.setVehicleNumber("KA2345");
        bookingInformationDto.setVehicleDto(aVehicleDto);
        List<BookingInformationDto> list = new ArrayList<>();
        list.add(bookingInformationDto);

        doReturn(mapper.mapDtos2Entities(list)).when(daoMock).findByParkingSpotIdParkingSpotId(any());

        List<BookingInformationDto> result = serviceMock.findBookingInfoByParkingSpotIdParkingSpotId(123L);
        Assert.assertEquals(list.size(), result.size());

    }

    @Test
    public void test_Given_Date_When_findBookingInfoByBookingTime_BookingInformationDto() {

        BookingInformationDto bookingInformationDto = factory.manufacturePojoWithFullData(BookingInformationDto.class);
        bookingInformationDto.setBookingId("123");
        VehicleDto aVehicleDto = factory.manufacturePojoWithFullData(VehicleDto.class);
        aVehicleDto.setVehicleType(VehicleType.CAR.name());
        ParkingSpotDto spotDto = factory.manufacturePojoWithFullData(ParkingSpotDto.class);
        spotDto.setParkingSpotType(SpotType.MEDIUM.name());
        spotDto.setParkingSpotId(123L);
        bookingInformationDto.setParkingSpot(spotDto);
        aVehicleDto.setVehicleNumber("KA2345");
        bookingInformationDto.setVehicleDto(aVehicleDto);
        List<BookingInformationDto> list = new ArrayList<>();
        list.add(bookingInformationDto);

        doReturn(mapper.mapDtos2Entities(list)).when(daoMock).findByBookingTime(any());

        SimpleDateFormat format = new SimpleDateFormat("DD-MM-YYYY");
        String date =format.format(bookingInformationDto.getBookingTime());

        List<BookingInformationDto> result = serviceMock.findBookingInfoByBookingTime(date);
        Assert.assertEquals(list.size(), result.size());

    }
}
