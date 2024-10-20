package uz.pdp.revolusion_intern_demo.service;

import uz.pdp.revolusion_intern_demo.dto.ApiResult;
import uz.pdp.revolusion_intern_demo.dto.PaymentDTO;
import uz.pdp.revolusion_intern_demo.dto.crudDTOs.PaymentCrudDTO;

import java.util.List;

public interface PaymentService {

    ApiResult<List<PaymentDTO>> readAll(int page, int size);

    ApiResult<PaymentDTO> readById(Long id);

    ApiResult<PaymentDTO> create(PaymentCrudDTO crudDTO);

}
