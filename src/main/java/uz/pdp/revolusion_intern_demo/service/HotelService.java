package uz.pdp.revolusion_intern_demo.service;

import uz.pdp.revolusion_intern_demo.dto.ApiResult;
import uz.pdp.revolusion_intern_demo.dto.crudDTOs.HotelCrudDTO;
import uz.pdp.revolusion_intern_demo.dto.HotelDTO;

import java.util.List;

public interface HotelService {

    ApiResult<List<HotelDTO>> readAll(int page, int size);

    ApiResult<HotelDTO> readById(Long id);

    ApiResult<HotelDTO> create(HotelCrudDTO crudDTO);

    ApiResult<HotelDTO> update(HotelCrudDTO crudDTO, Long id);

    ApiResult<String> delete(Long id);



}
