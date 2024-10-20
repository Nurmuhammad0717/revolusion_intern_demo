package uz.pdp.revolusion_intern_demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import uz.pdp.revolusion_intern_demo.entity.templates.AbsLongEntity;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "hotel")
public class Hotel extends AbsLongEntity {

    private String name;

    private String address;

    @Column(unique = true)
    private String contactNumber;

}