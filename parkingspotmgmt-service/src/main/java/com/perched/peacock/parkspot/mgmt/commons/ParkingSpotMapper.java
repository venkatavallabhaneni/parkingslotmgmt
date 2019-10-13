package com.perched.peacock.parkspot.mgmt.commons;

import com.perched.peacock.parkspot.mgmt.domain.*;
import com.perched.peacock.parkspot.mgmt.dto.ParkingLotDto;
import com.perched.peacock.parkspot.mgmt.dto.ParkingSpotDto;
import com.perched.peacock.parkspot.mgmt.dto.VehicleDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public abstract class ParkingSpotMapper {

    public abstract ParkingSpotDto mapEntity2Dto(ParkingSpot source);

    public abstract ParkingSpot mapDto2Entity(ParkingSpotDto source);

    public abstract List<ParkingSpotDto> mapEntities2Dtos(List<ParkingSpot> source);

    public abstract List<ParkingSpot> mapDtos2Entities(List<ParkingSpotDto> source);

    @AfterMapping
    public void mapDtoExtraInformation(ParkingSpotDto source, @MappingTarget ParkingSpot target) {

        target.setParkingSpotType(SpotType.valueOf(source.getParkingSpotType()));
    }

    @AfterMapping
    public void mapEntityExtraInformation(ParkingSpot source, @MappingTarget ParkingSpotDto target) {

        target.setParkingSpotType(source.getParkingSpotType().name());
    }
}
