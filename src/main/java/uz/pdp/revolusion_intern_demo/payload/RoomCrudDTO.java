package uz.pdp.revolusion_intern_demo.payload;

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
    private Long hotelIdId;
    private Boolean isBusy;
    private RoomTypeEnum roomType;
    private Integer roomNumber;
    private Double price;
}