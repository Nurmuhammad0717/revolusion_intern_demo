package uz.pdp.revolusion_intern_demo.dto.crudDTOs;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link uz.pdp.revolusion_intern_demo.entity.Rate}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateCrudDTO implements Serializable {

    @NotNull
    private Long userId;

    @NotNull
    private Long roomId;

    private String description;

    private Integer rate;
}