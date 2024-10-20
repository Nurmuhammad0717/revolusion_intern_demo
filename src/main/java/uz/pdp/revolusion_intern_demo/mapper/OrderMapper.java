package uz.pdp.revolusion_intern_demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import uz.pdp.revolusion_intern_demo.entity.Order;
import uz.pdp.revolusion_intern_demo.dto.crudDTOs.OrderCrudDTO;
import uz.pdp.revolusion_intern_demo.dto.OrderDTO;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    OrderDTO toDto(Order order);

    Order toEntity(OrderCrudDTO crudDTO);

    List<OrderDTO> toDto(List<Order> orders);

    void update(@MappingTarget Order order, OrderCrudDTO crudDTO);


}