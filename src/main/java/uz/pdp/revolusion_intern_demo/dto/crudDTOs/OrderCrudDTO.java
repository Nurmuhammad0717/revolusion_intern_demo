package uz.pdp.revolusion_intern_demo.dto.crudDTOs;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.revolusion_intern_demo.entity.Order;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link Order}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCrudDTO implements Serializable {

    @NotNull
    private Long userId;

    @NotNull
    private Long roomId;

    @NotNull
    private Date startDate;

    private Date endDate;

    private String description;
}