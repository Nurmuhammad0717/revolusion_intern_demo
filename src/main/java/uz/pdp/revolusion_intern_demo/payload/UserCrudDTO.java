package uz.pdp.revolusion_intern_demo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link uz.pdp.revolusion_intern_demo.entity.User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCrudDTO implements Serializable {
    private String email;
    private String password;
    private String fullName;
}