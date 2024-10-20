package uz.pdp.revolusion_intern_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TokenDTO {

    private String token;

    private UserDTO userDTO;

}
