package uz.pdp.revolusion_intern_demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.revolusion_intern_demo.dto.ApiResult;
import uz.pdp.revolusion_intern_demo.dto.OrderDTO;
import uz.pdp.revolusion_intern_demo.dto.crudDTOs.OrderCrudDTO;
import uz.pdp.revolusion_intern_demo.service.OrderService;
import uz.pdp.revolusion_intern_demo.utils.AppConstant;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppConstant.BASE_PATH_V1+"/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/read_all")
    public ApiResult<List<OrderDTO>> readAll(@RequestParam int page, @RequestParam int size) {

        return orderService.readAll(page,size);
    }

    @GetMapping("/read{id}")
    public ApiResult<OrderDTO> readById(@PathVariable Long id) {
        return orderService.readById(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ApiResult<OrderDTO> create(@RequestBody OrderCrudDTO crudDTO) {

        return orderService.create(crudDTO);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping("/update{id}")
    public ApiResult<OrderDTO> updateHotel(@RequestBody OrderCrudDTO crudDTO, @PathVariable Long id) {

        return orderService.update(id,crudDTO);
    }

    @GetMapping("/readByUserId")
    public ApiResult<List<OrderDTO>> readByUserId(@RequestParam Long userId) {
        return orderService.readByUserId(userId);
    }

}
