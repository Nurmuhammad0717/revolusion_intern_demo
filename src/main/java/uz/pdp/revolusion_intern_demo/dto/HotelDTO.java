package uz.pdp.revolusion_intern_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link uz.pdp.revolusion_intern_demo.entity.Hotel}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO implements Serializable {
    private Long id;
    private String name;
    private String address;
    private String contactNumber;
}