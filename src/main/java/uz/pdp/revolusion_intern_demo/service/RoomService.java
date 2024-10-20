package uz.pdp.revolusion_intern_demo.service;

import uz.pdp.revolusion_intern_demo.dto.ApiResult;
import uz.pdp.revolusion_intern_demo.dto.crudDTOs.RoomCrudDTO;
import uz.pdp.revolusion_intern_demo.dto.RoomDTO;

import java.util.List;

public interface RoomService {

    ApiResult<List<RoomDTO>> readAll(int page, int size);

    ApiResult<RoomDTO> readById(Long id);

    ApiResult<RoomDTO> create(RoomCrudDTO crudDTO);

    ApiResult<RoomDTO> update(RoomCrudDTO crudDTO, Long id);

    ApiResult<String> delete(Long id);



}
