package uz.pdp.revolusion_intern_demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.revolusion_intern_demo.dto.ApiResult;
import uz.pdp.revolusion_intern_demo.dto.PaymentDTO;
import uz.pdp.revolusion_intern_demo.dto.crudDTOs.PaymentCrudDTO;
import uz.pdp.revolusion_intern_demo.entity.Order;
import uz.pdp.revolusion_intern_demo.entity.Payment;
import uz.pdp.revolusion_intern_demo.enums.OrderStatusEnum;
import uz.pdp.revolusion_intern_demo.exception.RestException;
import uz.pdp.revolusion_intern_demo.mapper.PaymentMapper;
import uz.pdp.revolusion_intern_demo.repository.OrderRepository;
import uz.pdp.revolusion_intern_demo.repository.PaymentRepository;
import uz.pdp.revolusion_intern_demo.service.PaymentService;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final OrderRepository orderRepository;

    @Override
    public ApiResult<List<PaymentDTO>> readAll(int page, int size) {

        List<PaymentDTO> paymentDTO = paymentMapper.toDto(paymentRepository.findAll());

        return ApiResult.success(paymentDTO);
    }

    @Override
    public ApiResult<PaymentDTO> readById(Long id) {

        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> RestException.notFound("Any payment with id " + id));

        PaymentDTO paymentDTO = paymentMapper.toDto(payment);

        return ApiResult.success(paymentDTO);
    }


    @Override
    public ApiResult<PaymentDTO> create(PaymentCrudDTO crudDTO) {

        Payment payment = paymentMapper.toEntity(crudDTO);

        Order order = orderRepository.findById(crudDTO.getOrderId())
                .orElseThrow(() -> RestException.notFound("Order with id " + crudDTO.getOrderId()));

        payment.setOrder(order);

        order.setOrderStatus(OrderStatusEnum.CLOSED);

        orderRepository.save(order);

        Payment saved = paymentRepository.save(payment);

        PaymentDTO paymentDTO = paymentMapper.toDto(saved);

        return ApiResult.success(paymentDTO);
    }




}
