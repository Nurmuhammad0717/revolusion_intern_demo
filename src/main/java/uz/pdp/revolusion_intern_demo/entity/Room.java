package uz.pdp.revolusion_intern_demo.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.revolusion_intern_demo.entity.templates.AbsLongEntity;
import uz.pdp.revolusion_intern_demo.enums.RoomTypeEnum;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "room")
public class Room extends AbsLongEntity {

    @ManyToOne
    private Hotel hotel;

    private Boolean isBusy;

    @Enumerated(EnumType.STRING)
    private RoomTypeEnum roomType;

    @Column(unique = true)
    private Integer roomNumber;

    private Double price;

}