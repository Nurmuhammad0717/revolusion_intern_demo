package uz.pdp.revolusion_intern_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link uz.pdp.revolusion_intern_demo.entity.Payment}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO implements Serializable {
    private Long id;
    private Long orderId;
    private Double amount;
}