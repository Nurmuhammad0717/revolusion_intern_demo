package uz.pdp.revolusion_intern_demo.service;

import uz.pdp.revolusion_intern_demo.dto.ApiResult;
import uz.pdp.revolusion_intern_demo.dto.crudDTOs.RateCrudDTO;
import uz.pdp.revolusion_intern_demo.dto.RateDTO;

import java.util.List;

public interface RateService {

    ApiResult<List<RateDTO>> readAll(int page, int size);

    ApiResult<RateDTO> readById(Long id);

    ApiResult<RateDTO> create(RateCrudDTO crudDTO);

    ApiResult<RateDTO> update(RateCrudDTO crudDTO, Long id);

    ApiResult<String> delete(Long id);



}
