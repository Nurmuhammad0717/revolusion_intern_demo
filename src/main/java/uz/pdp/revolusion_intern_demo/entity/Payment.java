package uz.pdp.revolusion_intern_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import uz.pdp.revolusion_intern_demo.entity.templates.AbsLongEntity;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "payment")
public class Payment extends AbsLongEntity {

    @OneToOne
    private Order order;

    private Double amount;

}