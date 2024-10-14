package uz.pdp.revolusion_intern_demo.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignUpDTO {

    @Email(message = "Email_should_be_valid")
    private String email;

    @NotNull(message = "password_must_not_be_null")
    private String password;

    @NotNull(message = "username_must_not_be_null")
    @NotBlank
    private String fullName;




}
