package uz.pdp.revolusion_intern_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.revolusion_intern_demo.enums.RoleEnum;

import java.io.Serializable;

/**
 * DTO for {@link uz.pdp.revolusion_intern_demo.entity.User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    private Long id;
    private String email;
    private String fullName;
    private RoleEnum role;
}