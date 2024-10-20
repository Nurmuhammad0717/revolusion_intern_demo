package uz.pdp.revolusion_intern_demo.dto.crudDTOs;

import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private Long orderId;

    @NotNull
    private Date orderStartDate;

    @NotNull
    private Date orderEndDate;

    @NotNull
    private OrderStatusEnum orderOrderStatus;

    private String orderDescription;

    @NotNull
    private Double amount;
}