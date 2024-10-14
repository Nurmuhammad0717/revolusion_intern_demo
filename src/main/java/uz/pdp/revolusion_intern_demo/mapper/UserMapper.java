package uz.pdp.revolusion_intern_demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import uz.pdp.revolusion_intern_demo.entity.User;
import uz.pdp.revolusion_intern_demo.payload.UserDTO;
import uz.pdp.revolusion_intern_demo.payload.UserUpdateDTO;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserDTO toDto(User user);

    void update(@MappingTarget User user, UserUpdateDTO crudDTO);
}