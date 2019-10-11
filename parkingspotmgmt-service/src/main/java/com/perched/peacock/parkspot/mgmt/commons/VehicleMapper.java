package com.perched.peacock.parkspot.mgmt.commons;

import com.perched.peacock.parkspot.mgmt.domain.ParkingSpot;
import com.perched.peacock.parkspot.mgmt.domain.Vehicle;
import com.perched.peacock.parkspot.mgmt.domain.VehicleType;
import com.perched.peacock.parkspot.mgmt.dto.ParkingSpotDto;
import com.perched.peacock.parkspot.mgmt.dto.VehicleDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public abstract class VehicleMapper {

    public abstract VehicleDto mapEntity2Dto(Vehicle source);

    public abstract Vehicle mapDto2Entity(VehicleDto source);

    public abstract List<VehicleDto> mapEntity2DtoList(List<Vehicle> source);

    public abstract List<Vehicle> mapDto2Entities(List<VehicleDto> source);

    @AfterMapping
    public void mapDtoExtraInformation(VehicleDto source, @MappingTarget Vehicle target) {

        target.setVehicleType(VehicleType.valueOf(source.getVehicleType()));
    }

    @AfterMapping
    public void mapEntityExtraInformation(Vehicle source, @MappingTarget VehicleDto target) {

        target.setVehicleType(source.getVehicleType().name());
    }
}
