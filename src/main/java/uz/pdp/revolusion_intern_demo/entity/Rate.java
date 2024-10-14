package uz.pdp.revolusion_intern_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import uz.pdp.revolusion_intern_demo.entity.templates.AbsLongEntity;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "rate")
public class Rate extends AbsLongEntity {

    @ManyToOne
    private User userId;

    @ManyToOne
    private Room roomId;

    private String description;

    private Integer rate;

}