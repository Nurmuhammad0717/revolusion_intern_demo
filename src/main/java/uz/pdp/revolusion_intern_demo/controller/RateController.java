package uz.pdp.revolusion_intern_demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.revolusion_intern_demo.dto.ApiResult;
import uz.pdp.revolusion_intern_demo.dto.RateDTO;
import uz.pdp.revolusion_intern_demo.dto.crudDTOs.RateCrudDTO;
import uz.pdp.revolusion_intern_demo.service.RateService;
import uz.pdp.revolusion_intern_demo.utils.AppConstant;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppConstant.BASE_PATH_V1+"/rate")
public class RateController {

    private final RateService rateService;

    @GetMapping("/read_all")
    public ApiResult<List<RateDTO>> readAll(@RequestParam int page, @RequestParam int size) {

        return rateService.readAll(page,size);
    }

    @GetMapping("/read{id}")
    public ApiResult<RateDTO> readById(@PathVariable Long id) {
        return rateService.readById(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ApiResult<RateDTO> create(@RequestBody RateCrudDTO crudDTO) {

        return rateService.create(crudDTO);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping("/update{id}")
    public ApiResult<RateDTO> updateHotel(@RequestBody RateCrudDTO crudDTO, @PathVariable Long id) {

        return rateService.update(crudDTO, id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")

    @DeleteMapping("/delete{id}")
    public ApiResult<String> deleteHotel(@PathVariable Long id) {

        return rateService.delete(id);
    }

}
