package com.perched.peacock.parkspot.mgmt.commons;

import com.perched.peacock.parkspot.mgmt.domain.BookingInformation;
import com.perched.peacock.parkspot.mgmt.domain.ParkingSpot;
import com.perched.peacock.parkspot.mgmt.domain.SpotType;
import com.perched.peacock.parkspot.mgmt.domain.Vehicle;
import com.perched.peacock.parkspot.mgmt.dto.BookingInformationDto;
import com.perched.peacock.parkspot.mgmt.dto.ParkingSpotDto;
import com.perched.peacock.parkspot.mgmt.dto.VehicleDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Mapper(componentModel = "spring")
public abstract class BookingMapper {

    public abstract BookingInformationDto mapEntity2Dto(BookingInformation source);

    public abstract BookingInformation mapDto2Entity(BookingInformationDto source);

    public abstract List<BookingInformationDto> mapEntities2Dtos(List<BookingInformation> source);

    public abstract List<BookingInformation> mapDtos2Entities(List<BookingInformationDto> source);

    public abstract VehicleDto mapVehicleEntity2Dto(Vehicle source);

    public abstract Vehicle mapVehicleDto2Entity(VehicleDto source);

    public abstract ParkingSpot mapParkingSpotDto2Entity(ParkingSpotDto source);

    public abstract ParkingSpotDto mapParkingSpotEntity2Dto(ParkingSpot source);

    public void setTotalCost(BookingInformationDto source) {
        if (source.getExitTime() == null) {
            return;
        }
        source.setTotalCost(source.getParkingSpot().getPrice() * hoursDifference(source.getExitTime(), source.getEntryTime()));

    }

    private static int hoursDifference(Date date1, Date date2) {

        final int MILLI_TO_HOUR = 1000 * 60 * 60;
        return (int) (date1.getTime() - date2.getTime()) / MILLI_TO_HOUR;
    }

    @AfterMapping
    public void mapDtoExtraInformation(BookingInformationDto source, @MappingTarget BookingInformation target) {

        target.setVehicleId(mapVehicleDto2Entity(source.getVehicleDto()));
        target.setParkingSpotId(mapParkingSpotDto2Entity(source.getParkingSpot()));
    }

    @AfterMapping
    public void mapEntityExtraInformation(BookingInformation source, @MappingTarget BookingInformationDto target) {

        target.setParkingSpot(mapParkingSpotEntity2Dto(source.getParkingSpotId()));
        target.setVehicleDto(mapVehicleEntity2Dto(source.getVehicleId()));
        setTotalCost(target);


    }
}
