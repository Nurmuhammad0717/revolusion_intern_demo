package uz.pdp.revolusion_intern_demo.dto;

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
public class RoomDTO implements Serializable {
    private Long id;
    private Long hotelId;
    private Boolean isBusy;
    private RoomTypeEnum roomType;
    private Integer roomNumber;
    private Double price;
}