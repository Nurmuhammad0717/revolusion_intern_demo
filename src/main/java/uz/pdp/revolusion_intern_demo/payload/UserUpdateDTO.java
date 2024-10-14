package uz.pdp.revolusion_intern_demo.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class UserUpdateDTO implements Serializable {

    @Email
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String fullName;



}
