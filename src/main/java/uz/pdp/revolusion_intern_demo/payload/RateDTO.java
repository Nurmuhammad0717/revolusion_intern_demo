package uz.pdp.revolusion_intern_demo.payload;

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
public class RateDTO implements Serializable {
    private Long id;
    private Long userIdId;
    private Long roomIdId;
    private String description;
    private Integer rate;
}