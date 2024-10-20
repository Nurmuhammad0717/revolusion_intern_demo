package uz.pdp.revolusion_intern_demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.revolusion_intern_demo.dto.ApiResult;
import uz.pdp.revolusion_intern_demo.dto.HotelDTO;
import uz.pdp.revolusion_intern_demo.dto.crudDTOs.HotelCrudDTO;
import uz.pdp.revolusion_intern_demo.service.HotelService;
import uz.pdp.revolusion_intern_demo.utils.AppConstant;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppConstant.BASE_PATH_V1+"/hotel")
public class HotelController {

    private final HotelService hotelService;

    @GetMapping("/read_all")
    public ApiResult<List<HotelDTO>> readAll(@RequestParam int page, @RequestParam int size) {

        return hotelService.readAll(page,size);
    }

    @GetMapping("/read{id}")
    public ApiResult<HotelDTO> readById(@PathVariable Long id) {
        return hotelService.readById(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ApiResult<HotelDTO> create(@RequestBody HotelCrudDTO crudDTO) {

        return hotelService.create(crudDTO);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping("/update{id}")
    public ApiResult<HotelDTO> updateHotel(@RequestBody HotelCrudDTO crudDTO, @PathVariable Long id) {

        return hotelService.update(crudDTO, id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")

    @DeleteMapping("/delete{id}")
    public ApiResult<String> deleteHotel(@PathVariable Long id) {

        return hotelService.delete(id);
    }

}
