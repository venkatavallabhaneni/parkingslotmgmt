package com.perched.peacock.parkspot.mgmt.service;

import com.perched.peacock.parkspot.mgmt.commons.ParkingLotMapper;
import com.perched.peacock.parkspot.mgmt.dao.ParkingLotDao;
import com.perched.peacock.parkspot.mgmt.domain.ParkingLot;
import com.perched.peacock.parkspot.mgmt.dto.ParkingLotDto;
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
public class ParkingLotServiceImplTest {

    Logger logger = LoggerFactory.getLogger(ParkingLotServiceImplTest.class);

    private ParkingLotMapper mapper = null;

    @Mock
    private ParkingLotDao daoMock;

    @InjectMocks
    private ParkingLotServiceImpl serviceMock;

    private ParkingLot aParkingLot = null;

    PodamFactory factory = null;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        aParkingLot = mock(ParkingLot.class);
        mapper = Mappers.getMapper(ParkingLotMapper.class);
        factory = new PodamFactoryImpl();
    }

    @Test
    public void test_Given_ParkingLotObject_When_Create_Return_ParkingLot() {

        ParkingLot parkingLot = factory.manufacturePojoWithFullData(ParkingLot.class);
        List<ParkingLot> list = new ArrayList<>();
        list.add(parkingLot);

        doReturn(list).when(daoMock).saveAll(list);

        List<ParkingLotDto> result = serviceMock.create(mapper.mapEntities2Dtos(list));
        Assert.assertEquals(list.size(), result.size());

    }

    @Test
    public void test_Given_LotId_When_findByLotId_Return_ParkingLot() {

        ParkingLot parkingLot = factory.manufacturePojoWithFullData(ParkingLot.class);
        parkingLot.setId(123L);

        doReturn(parkingLot).when(daoMock).findById(any());

        ParkingLotDto result = serviceMock.findByLotId(123L);
        Assert.assertEquals(parkingLot.getName(), result.getName());

    }

    @Test
    public void test_Given_Nothing_When_findAll_ParkingLot() {

        ParkingLot parkingLot = factory.manufacturePojoWithFullData(ParkingLot.class);
        List<ParkingLot> list = new ArrayList<>();
        list.add(parkingLot);

        doReturn(list).when(daoMock).findAll();

        List<ParkingLotDto> result = serviceMock.findAll();
        Assert.assertEquals(list.size(), result.size());

    }

    @Test
    public void test_Given_LotName_When_findByLotName_Return_ParkingLot() {

        ParkingLot parkingLot = factory.manufacturePojoWithFullData(ParkingLot.class);
        parkingLot.setName("YOU");

        doReturn(Optional.of(parkingLot)).when(daoMock).findByName("YOU");

        ParkingLotDto result = serviceMock.findByLotName("YOU");
        Assert.assertEquals(parkingLot.getName(), result.getName());

    }

    @Test
    public void test_Given_parkingLot_When_delete_Return_Boolean() {

        ParkingLotDto parkingLot = factory.manufacturePojoWithFullData(ParkingLotDto.class);
        parkingLot.setName("YOU");
        boolean result = serviceMock.delete(parkingLot);
        Assert.assertEquals(result, true);

    }


}
