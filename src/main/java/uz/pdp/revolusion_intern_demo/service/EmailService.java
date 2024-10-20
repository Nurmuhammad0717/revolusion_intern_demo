package uz.pdp.revolusion_intern_demo.service;


import uz.pdp.revolusion_intern_demo.dto.ApiResult;
import uz.pdp.revolusion_intern_demo.dto.UserDTO;

public interface EmailService {

   ApiResult<UserDTO> sendVerificationCode(UserDTO userDTO);

}
