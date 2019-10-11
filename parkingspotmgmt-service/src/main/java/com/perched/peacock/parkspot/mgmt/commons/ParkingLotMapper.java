package com.perched.peacock.parkspot.mgmt.commons;

import com.perched.peacock.parkspot.mgmt.domain.ParkingLot;
import com.perched.peacock.parkspot.mgmt.dto.ParkingLotDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public abstract class ParkingLotMapper {
    public abstract ParkingLotDto mapEntity2Dto(ParkingLot source);

    public abstract ParkingLot mapDto2Entity(ParkingLotDto source);

    public abstract List<ParkingLotDto> mapEntity2DtoList(List<ParkingLot> source);

    public abstract List<ParkingLot> mapDto2Entities(List<ParkingLotDto> source);
}
