package uz.pdp.revolusion_intern_demo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResetPasswordDTO {

    private String email;

    private Integer verificationCode;

    private String newPassword;

}
