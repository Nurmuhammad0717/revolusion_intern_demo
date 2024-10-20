package uz.pdp.revolusion_intern_demo.dto.crudDTOs;

import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String fullName;
}