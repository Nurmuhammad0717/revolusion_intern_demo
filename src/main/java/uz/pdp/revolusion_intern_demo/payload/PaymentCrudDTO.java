package uz.pdp.revolusion_intern_demo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.revolusion_intern_demo.enums.OrderStatusEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link uz.pdp.revolusion_intern_demo.entity.Payment}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentCrudDTO implements Serializable {
    private Long orderId;
    private Date orderStartDate;
    private Date orderEndDate;
    private OrderStatusEnum orderOrderStatus;
    private String orderDescription;
    private Double amount;
}