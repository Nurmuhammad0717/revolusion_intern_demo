package uz.pdp.revolusion_intern_demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import uz.pdp.revolusion_intern_demo.entity.Room;
import uz.pdp.revolusion_intern_demo.payload.RoomCrudDTO;
import uz.pdp.revolusion_intern_demo.payload.RoomDTO;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoomMapper {

    RoomDTO toDto(Room room);

    Room toEntity(RoomCrudDTO crudDTO);

    List<RoomDTO> toDto(List<Room> hotels);

    void update(@MappingTarget Room room, RoomCrudDTO crudDTO);

}