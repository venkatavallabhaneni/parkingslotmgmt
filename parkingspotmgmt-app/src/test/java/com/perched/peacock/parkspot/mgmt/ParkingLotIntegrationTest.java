package com.perched.peacock.parkspot.mgmt;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
@TestPropertySource(locations = "classpath:application-integrationtest.proprties")
public class ParkingLotIntegrationTest {


}
