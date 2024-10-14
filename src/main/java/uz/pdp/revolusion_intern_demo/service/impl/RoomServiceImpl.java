package uz.pdp.revolusion_intern_demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.revolusion_intern_demo.entity.Room;
import uz.pdp.revolusion_intern_demo.exception.RestException;
import uz.pdp.revolusion_intern_demo.mapper.RoomMapper;
import uz.pdp.revolusion_intern_demo.payload.ApiResult;
import uz.pdp.revolusion_intern_demo.payload.RoomCrudDTO;
import uz.pdp.revolusion_intern_demo.payload.RoomDTO;
import uz.pdp.revolusion_intern_demo.repository.RoomRepository;
import uz.pdp.revolusion_intern_demo.service.RoomService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    @Override
    public ApiResult<List<RoomDTO>> readAll(int page, int size) {

        List<RoomDTO> roomDTOS = roomMapper.toDto(roomRepository.findAll());

        return ApiResult.success(roomDTOS);
    }

    @Override
    public ApiResult<RoomDTO> readById(Long id) {

        Room room = roomRepository.findById(id)
                .orElseThrow(() -> RestException.notFound("Any room with id " + id));

        RoomDTO hotelDTO = roomMapper.toDto(room);

        return ApiResult.success(hotelDTO);
    }

    @Override
    public ApiResult<RoomDTO> create(RoomCrudDTO crudDTO) {

        Room room = roomMapper.toEntity(crudDTO);

        Room saved = roomRepository.save(room);

        RoomDTO hotelDTO = roomMapper.toDto(saved);

        return ApiResult.success(hotelDTO);
    }

    @Override
    public ApiResult<RoomDTO> update(RoomCrudDTO crudDTO, Long id) {

        Room room = roomRepository.findById(id)
                .orElseThrow(() -> RestException.notFound("Any room with id " + id));

        roomMapper.update(room, crudDTO);

        RoomDTO hotelDTO = roomMapper.toDto(room);

        return ApiResult.success(hotelDTO);
    }

    @Override
    public ApiResult<String> delete(Long id) {

        roomRepository.deleteById(id);

        return ApiResult.success("Deleted room with id " + id);
    }
}
