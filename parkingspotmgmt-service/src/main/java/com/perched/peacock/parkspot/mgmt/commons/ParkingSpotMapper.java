package com.perched.peacock.parkspot.mgmt.commons;

import com.perched.peacock.parkspot.mgmt.domain.ParkingLot;
import com.perched.peacock.parkspot.mgmt.domain.ParkingSpot;
import com.perched.peacock.parkspot.mgmt.dto.ParkingLotDto;
import com.perched.peacock.parkspot.mgmt.dto.ParkingSpotDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public abstract class ParkingSpotMapper {

    public abstract ParkingSpotDto mapEntity2Dto(ParkingSpot source);

    public abstract ParkingSpot mapDto2Entity(ParkingSpotDto source);

    public abstract List<ParkingSpotDto> mapEntity2DtoList(List<ParkingSpot> source);

    public abstract List<ParkingSpot> mapDto2Entities(List<ParkingSpotDto> source);
}
