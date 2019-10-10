package com.perched.peacock.parkspot.mgmt.service;

import com.perched.peacock.parkspot.mgmt.dao.ParkingLotDao;
import com.perched.peacock.parkspot.mgmt.domain.ParkingLot;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;

public class ParkingLotServiceImplTest {

	@Mock
	private ParkingLotDao daoMock;

	@InjectMocks
	private ParkingLotServiceImpl serviceMock;

	private ParkingLot aParkingLot = null;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		aParkingLot = mock(ParkingLot.class);

	}
}
