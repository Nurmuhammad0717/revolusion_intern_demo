package uz.pdp.revolusion_intern_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.revolusion_intern_demo.enums.OrderStatusEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link uz.pdp.revolusion_intern_demo.entity.Order}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO implements Serializable {
    private Long id;
    private Long userId;
    private Long roomId;
    private Date startDate;
    private Date endDate;
    private OrderStatusEnum orderStatus;
    private String description;
}