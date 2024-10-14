package uz.pdp.revolusion_intern_demo.entity;

import jakarta.persistence.Entity;
import lombok.*;
import uz.pdp.revolusion_intern_demo.entity.templates.AbsLongEntity;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class CodeEntity extends AbsLongEntity {


    private String email;


    private Integer code;

}
