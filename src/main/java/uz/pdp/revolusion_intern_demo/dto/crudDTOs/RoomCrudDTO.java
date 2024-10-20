package uz.pdp.revolusion_intern_demo.dto.crudDTOs;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.revolusion_intern_demo.enums.RoomTypeEnum;

import java.io.Serializable;

/**
 * DTO for {@link uz.pdp.revolusion_intern_demo.entity.Room}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomCrudDTO implements Serializable {
    @NotNull
    private Long hotelId;

    @NotNull
    private Boolean isBusy;

    @NotNull
    private RoomTypeEnum roomType;

    @NotNull
    private Integer roomNumber;

    @NotNull
    private Double price;
}