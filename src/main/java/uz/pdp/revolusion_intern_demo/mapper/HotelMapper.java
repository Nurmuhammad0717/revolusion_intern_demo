package uz.pdp.revolusion_intern_demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import uz.pdp.revolusion_intern_demo.entity.Hotel;
import uz.pdp.revolusion_intern_demo.dto.crudDTOs.HotelCrudDTO;
import uz.pdp.revolusion_intern_demo.dto.HotelDTO;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface HotelMapper {

    HotelDTO toDto(Hotel hotel);

    Hotel toEntity(HotelCrudDTO crudDTO);

    List<HotelDTO> toDto(List<Hotel> hotels);

    void update(@MappingTarget Hotel hotel, HotelCrudDTO crudDTO);

}