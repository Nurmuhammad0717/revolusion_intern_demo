package uz.pdp.revolusion_intern_demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.revolusion_intern_demo.entity.Rate;
import uz.pdp.revolusion_intern_demo.exception.RestException;
import uz.pdp.revolusion_intern_demo.mapper.RateMapper;
import uz.pdp.revolusion_intern_demo.dto.ApiResult;
import uz.pdp.revolusion_intern_demo.dto.crudDTOs.RateCrudDTO;
import uz.pdp.revolusion_intern_demo.dto.RateDTO;
import uz.pdp.revolusion_intern_demo.repository.RateRepository;
import uz.pdp.revolusion_intern_demo.service.RateService;
import org.springframework.data.domain.PageRequest;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {

    private final RateRepository rateRepository;
    private final RateMapper rateMapper;

    @Override
    public ApiResult<List<RateDTO>> readAll(int page, int size) {

        List<RateDTO> rateDTOS = rateRepository.findAll(PageRequest.of(page, size)).stream().map(this::toDTO).toList();

        return ApiResult.success(rateDTOS);
    }

    @Override
    public ApiResult<RateDTO> readById(Long id) {

        Rate rate = rateRepository.findById(id)
                .orElseThrow(() -> RestException.notFound("Any rate with id " + id));

        RateDTO rateDTO = rateMapper.toDto(rate);

        return ApiResult.success(rateDTO);
    }

    @Override
    public ApiResult<RateDTO> create(RateCrudDTO crudDTO) {

        Rate rate = rateMapper.toEntity(crudDTO);

        Rate saved = rateRepository.save(rate);

        RateDTO rateDTO = rateMapper.toDto(saved);

        return ApiResult.success(rateDTO);
    }

    @Override
    public ApiResult<RateDTO> update(RateCrudDTO crudDTO, Long id) {

        Rate rate = rateRepository.findById(id)
                .orElseThrow(() -> RestException.notFound("Any rate with id " + id));

        rateMapper.update(rate, crudDTO);

        RateDTO rateDTO = rateMapper.toDto(rate);

        return ApiResult.success(rateDTO);
    }

    @Override
    public ApiResult<String> delete(Long id) {

        rateRepository.deleteById(id);

        return ApiResult.success("Deleted rate with id " + id);
    }

    private RateDTO toDTO(Rate rate) {
        RateDTO result = rateMapper.toDto(rate);
        result.setRoomId(rate.getRoom().getId());
        result.setUserId(rate.getUser().getId());
        return result;
    }
}
