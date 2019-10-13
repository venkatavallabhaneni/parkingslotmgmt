package com.perched.peacock.parkspot.mgmt.service;

import com.perched.peacock.parkspot.mgmt.commons.BookingMapper;
import com.perched.peacock.parkspot.mgmt.dao.BookingInformationDao;
import com.perched.peacock.parkspot.mgmt.dao.ParkingRecordsDao;
import com.perched.peacock.parkspot.mgmt.domain.BookingInformation;
import com.perched.peacock.parkspot.mgmt.dto.BookingInformationDto;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookingInformationServiceImpl implements BookingInformationService {

    private ParkingRecordsDao parkingRecordsDao;

    private BookingMapper mapper = Mappers.getMapper(BookingMapper.class);

    @Autowired
    public BookingInformationServiceImpl(ParkingRecordsDao parkingRecordsDao) {
        this.parkingRecordsDao = parkingRecordsDao;
    }

    @Override
    public List<BookingInformationDto> findBookingInfoByVehicleIdVehicleNumber(String regNumber) {

        List<BookingInformation> result = parkingRecordsDao.findByVehicleIdVehicleNumber(regNumber);

        return mapper.mapEntities2Dtos(result);
    }

    @Override
    public List<BookingInformationDto> findBookingInfoByParkingSpotIdParkingSpotId(Long spotId) {
        List<BookingInformation> result = parkingRecordsDao.findByParkingSpotIdParkingSpotId(spotId);

        return mapper.mapEntities2Dtos(result);
    }

    @Override
    public List<BookingInformationDto> findBookingInfoByBookingTime(String bookingTime) {
        List<BookingInformation> result = parkingRecordsDao.findByBookingTime(bookingTime);
        return mapper.mapEntities2Dtos(result);
    }
}
