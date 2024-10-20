package uz.pdp.revolusion_intern_demo.dto.crudDTOs;

import jakarta.validation.constraints.NotNull;
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

    @NotNull
    private String name;

    @NotNull
    private String address;

    @NotNull
    private String contactNumber;
}