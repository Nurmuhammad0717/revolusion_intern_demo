package uz.pdp.revolusion_intern_demo.dto.crudDTOs;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignInDTO {

    @NotNull
    private String email;

    @NotNull
    private String password;

}
