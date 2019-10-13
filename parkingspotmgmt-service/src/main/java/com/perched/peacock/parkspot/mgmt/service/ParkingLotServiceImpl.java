package com.perched.peacock.parkspot.mgmt.service;

import com.perched.peacock.parkspot.mgmt.commons.ParkingLotMapper;
import com.perched.peacock.parkspot.mgmt.dao.ParkingLotDao;
import com.perched.peacock.parkspot.mgmt.domain.ParkingLot;
import com.perched.peacock.parkspot.mgmt.dto.ParkingLotDto;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ParkingLotServiceImpl implements ParkingLotService {


    private ParkingLotDao parkingLotDao;

    private ParkingLotMapper mapper = Mappers.getMapper(ParkingLotMapper.class);

    @Autowired
    public ParkingLotServiceImpl(ParkingLotDao parkingLotDao) {
        this.parkingLotDao = parkingLotDao;
    }

    @Override
    public ParkingLotDto findByLotId(Long lotId) {
        ParkingLot aParkingLot = parkingLotDao.findById(lotId);
        return mapper.mapEntity2Dto(aParkingLot);
    }

    @Override
    public ParkingLotDto findByLotName(String lotName) {

        Optional<ParkingLot> aParkingLot = parkingLotDao.findByName(lotName);
        if (aParkingLot.isPresent()) {
            return mapper.mapEntity2Dto(aParkingLot.get());
        }
        return null;
    }

    @Override
    public List<ParkingLotDto> findAll() {
        Iterable<ParkingLot> parkingLots = parkingLotDao.findAll();
        return mapper.mapEntities2Dtos(StreamSupport.stream(parkingLots.spliterator(), true).collect(Collectors.toList()));
    }


    @Override
    public List<ParkingLotDto> create(List<ParkingLotDto> parkingLots) {

        Iterable<ParkingLot> lots = parkingLotDao.saveAll(mapper.mapDtos2Entities(parkingLots));

        return mapper.mapEntities2Dtos(StreamSupport.stream(lots.spliterator(), true).collect(Collectors.toList()));
    }

    @Override
    public boolean delete(ParkingLotDto parkingLot) {
        parkingLotDao.delete(mapper.mapDto2Entity(parkingLot));
        return true;
    }
}
