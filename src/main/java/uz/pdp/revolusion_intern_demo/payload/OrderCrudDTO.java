package uz.pdp.revolusion_intern_demo.payload;

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
    private Long userIdId;
    private Long roomIdId;
    private Date startDate;
    private Date endDate;
    private String description;
}