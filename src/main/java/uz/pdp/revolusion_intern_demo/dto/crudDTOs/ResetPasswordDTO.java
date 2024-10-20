package uz.pdp.revolusion_intern_demo.dto.crudDTOs;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResetPasswordDTO {

    @NotNull
    private String email;

    @NotNull
    private Integer verificationCode;

    @NotNull
    private String newPassword;

}
