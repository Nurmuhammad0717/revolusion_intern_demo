package uz.pdp.revolusion_intern_demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import uz.pdp.revolusion_intern_demo.entity.Rate;
import uz.pdp.revolusion_intern_demo.dto.crudDTOs.RateCrudDTO;
import uz.pdp.revolusion_intern_demo.dto.RateDTO;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RateMapper {

    RateDTO toDto(Rate rate);

    Rate toEntity(RateCrudDTO crudDTO);

    List<RateDTO> toDto(List<Rate> rates);

    void update(@MappingTarget Rate rate, RateCrudDTO crudDTO);

}