package uz.pdp.revolusion_intern_demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.pdp.revolusion_intern_demo.dto.ApiResult;
import uz.pdp.revolusion_intern_demo.dto.crudDTOs.OrderCrudDTO;
import uz.pdp.revolusion_intern_demo.dto.OrderDTO;
import uz.pdp.revolusion_intern_demo.entity.Order;
import uz.pdp.revolusion_intern_demo.entity.Room;
import uz.pdp.revolusion_intern_demo.entity.User;
import uz.pdp.revolusion_intern_demo.enums.OrderStatusEnum;
import uz.pdp.revolusion_intern_demo.exception.RestException;
import uz.pdp.revolusion_intern_demo.mapper.OrderMapper;
import uz.pdp.revolusion_intern_demo.repository.OrderRepository;
import uz.pdp.revolusion_intern_demo.repository.RoomRepository;
import uz.pdp.revolusion_intern_demo.repository.UserRepository;
import uz.pdp.revolusion_intern_demo.service.OrderService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;


    @Override
    public ApiResult<List<OrderDTO>> readAll(int page, int size) {

        List<OrderDTO> orderDTOS = orderRepository.findAll(PageRequest
                        .of(page, size)).stream().map(this::toDTO).toList();

        return ApiResult.success(orderDTOS);
    }


    @Override
    public ApiResult<OrderDTO> readById(Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> RestException.notFound("Any order with id" + id));

        OrderDTO orderDTO = orderMapper.toDto(order);

        return ApiResult.success(orderDTO);
    }

    @Override
    public ApiResult<OrderDTO> create(OrderCrudDTO crudDTO) {

        List<Order> allByRoomId = orderRepository.findAllByRoomId(crudDTO.getRoomId());

        for (Order order : allByRoomId) {

            if(order.getOrderStatus().equals(OrderStatusEnum.PENDING))
                throw RestException.restThrow("This room has already been pending.");

            if(order.getOrderStatus().equals(OrderStatusEnum.ACCEPTED))
                throw RestException.restThrow("This room has already been booked.");

        }

        Room room = roomRepository.findById(crudDTO.getRoomId())
                .orElseThrow(() -> RestException.notFound("Any room with id" + crudDTO.getRoomId()));

        User user = userRepository.findById(crudDTO.getUserId())
                .orElseThrow(() -> RestException.notFound("Any user with id" + crudDTO.getUserId()));

        Order order = orderMapper.toEntity(crudDTO);

        order.setOrderStatus(OrderStatusEnum.PENDING);
        order.setUser(user);
        order.setRoom(room);
        Order saved = orderRepository.save(order);


        return ApiResult.success(orderMapper.toDto(saved));
    }

    @Override
    public ApiResult<OrderDTO> update(Long id, OrderCrudDTO crudDTO) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> RestException.notFound("Any order with id" + id));

        orderMapper.update(order, crudDTO);


        return ApiResult.success(orderMapper.toDto(order));
    }

    @Override
    public ApiResult<List<OrderDTO>> readByUserId(Long id) {

        return ApiResult.success(orderMapper.toDto(orderRepository.findAll()));
    }

    private OrderDTO toDTO(Order order) {
        OrderDTO dto = orderMapper.toDto(order);
        dto.setUserId(order.getUser().getId());
        dto.setRoomId(order.getRoom().getId());
        return dto;
    }
}
