package uz.pdp.revolusion_intern_demo.service;

import uz.pdp.revolusion_intern_demo.dto.ApiResult;
import uz.pdp.revolusion_intern_demo.dto.crudDTOs.OrderCrudDTO;
import uz.pdp.revolusion_intern_demo.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    ApiResult<List<OrderDTO>> readAll(int page, int size);

    ApiResult<OrderDTO> readById(Long id);

    ApiResult<OrderDTO> create(OrderCrudDTO crudDTO);

    ApiResult<OrderDTO> update(Long orderId, OrderCrudDTO crudDTO);

    ApiResult<List<OrderDTO>> readByUserId(Long id);





}
