package uz.pdp.revolusion_intern_demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.revolusion_intern_demo.dto.ApiResult;
import uz.pdp.revolusion_intern_demo.dto.RoomDTO;
import uz.pdp.revolusion_intern_demo.dto.crudDTOs.RoomCrudDTO;
import uz.pdp.revolusion_intern_demo.service.RoomService;
import uz.pdp.revolusion_intern_demo.utils.AppConstant;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppConstant.BASE_PATH_V1+"/room")
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/read_all")
    public ApiResult<List<RoomDTO>> readAll(@RequestParam int page, @RequestParam int size) {

        return roomService.readAll(page,size);
    }

    @GetMapping("/read{id}")
    public ApiResult<RoomDTO> readById(@PathVariable Long id) {
        return roomService.readById(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ApiResult<RoomDTO> create(@RequestBody RoomCrudDTO crudDTO) {

        return roomService.create(crudDTO);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping("/update{id}")
    public ApiResult<RoomDTO> updateHotel(@RequestBody RoomCrudDTO crudDTO, @PathVariable Long id) {

        return roomService.update(crudDTO, id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")

    @DeleteMapping("/delete{id}")
    public ApiResult<String> deleteHotel(@PathVariable Long id) {

        return roomService.delete(id);
    }

}
