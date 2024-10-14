package uz.pdp.revolusion_intern_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;
import uz.pdp.revolusion_intern_demo.entity.templates.AbsLongEntity;
import uz.pdp.revolusion_intern_demo.enums.OrderStatusEnum;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "orders")
public class Order extends AbsLongEntity {

    @ManyToOne
    private User userId;

    @ManyToOne
    private Room roomId;

    private Date startDate;

    private Date endDate;

    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;

    private String description;


}