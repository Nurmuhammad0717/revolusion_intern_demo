package uz.pdp.revolusion_intern_demo.service;


import uz.pdp.revolusion_intern_demo.payload.ApiResult;
import uz.pdp.revolusion_intern_demo.payload.UserDTO;

public interface EmailService {

   ApiResult<UserDTO> sendVerificationCode(UserDTO userDTO);

}
