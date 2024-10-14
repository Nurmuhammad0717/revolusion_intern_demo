package uz.pdp.revolusion_intern_demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.revolusion_intern_demo.entity.Hotel;
import uz.pdp.revolusion_intern_demo.exception.RestException;
import uz.pdp.revolusion_intern_demo.mapper.HotelMapper;
import uz.pdp.revolusion_intern_demo.payload.ApiResult;
import uz.pdp.revolusion_intern_demo.payload.HotelCrudDTO;
import uz.pdp.revolusion_intern_demo.payload.HotelDTO;
import uz.pdp.revolusion_intern_demo.repository.HotelRepository;
import uz.pdp.revolusion_intern_demo.service.HotelService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    @Override
    public ApiResult<List<HotelDTO>> readAll(int page, int size) {

        List<HotelDTO> hotelDTOS = hotelMapper.toDto(hotelRepository.findAll());

        return ApiResult.success(hotelDTOS);
    }

    @Override
    public ApiResult<HotelDTO> readById(Long id) {

        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> RestException.notFound("Any hotel with id " + id));

        HotelDTO hotelDTO = hotelMapper.toDto(hotel);

        return ApiResult.success(hotelDTO);
    }

    @Override
    public ApiResult<HotelDTO> create(HotelCrudDTO crudDTO) {

        Hotel hotel = hotelMapper.toEntity(crudDTO);

        Hotel saved = hotelRepository.save(hotel);

        HotelDTO hotelDTO = hotelMapper.toDto(saved);

        return ApiResult.success(hotelDTO);
    }

    @Override
    public ApiResult<HotelDTO> update(HotelCrudDTO crudDTO, Long id) {

        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> RestException.notFound("Any hotel with id " + id));

        hotelMapper.update(hotel, crudDTO);

        HotelDTO hotelDTO = hotelMapper.toDto(hotel);

        return ApiResult.success(hotelDTO);
    }

    @Override
    public ApiResult<String> delete(Long id) {

        hotelRepository.deleteById(id);

        return ApiResult.success("Deleted hotel with id " + id);
    }
}
