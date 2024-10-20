package uz.pdp.revolusion_intern_demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import uz.pdp.revolusion_intern_demo.dto.*;
import uz.pdp.revolusion_intern_demo.dto.crudDTOs.CodeDTO;
import uz.pdp.revolusion_intern_demo.dto.crudDTOs.ResetPasswordDTO;
import uz.pdp.revolusion_intern_demo.dto.crudDTOs.SignInDTO;
import uz.pdp.revolusion_intern_demo.dto.crudDTOs.SignUpDTO;

public interface AuthService extends UserDetailsService {

    ApiResult<UserDTO> signUp(SignUpDTO signUpDTO);

    ApiResult<String> emailVerification(CodeDTO codeDto);

    ApiResult<TokenDTO> signIn(SignInDTO signInDTO);

    ApiResult<UserDTO> forgotPassword(String email);

    ApiResult<String> resetPassword(ResetPasswordDTO resetPasswordDTO);



}
