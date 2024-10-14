package uz.pdp.revolusion_intern_demo.service;

import uz.pdp.revolusion_intern_demo.payload.ApiResult;
import uz.pdp.revolusion_intern_demo.payload.HotelCrudDTO;
import uz.pdp.revolusion_intern_demo.payload.HotelDTO;

import java.util.List;

public interface HotelService {

    ApiResult<List<HotelDTO>> readAll(int page, int size);

    ApiResult<HotelDTO> readById(Long id);

    ApiResult<HotelDTO> create(HotelCrudDTO crudDTO);

    ApiResult<HotelDTO> update(HotelCrudDTO crudDTO, Long id);

    ApiResult<String> delete(Long id);



}
