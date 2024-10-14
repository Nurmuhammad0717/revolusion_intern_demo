package uz.pdp.revolusion_intern_demo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.revolusion_intern_demo.entity.Hotel;

import java.io.Serializable;

/**
 * DTO for {@link Hotel}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelCrudDTO implements Serializable {
    private String name;
    private String address;
    private String contactNumber;
}