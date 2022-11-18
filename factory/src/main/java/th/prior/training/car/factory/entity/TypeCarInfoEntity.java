package th.prior.training.car.factory.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "type_car_info")
@Data
public class TypeCarInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeId;

    private String typeGroup;

    private String typePart;

    private int typeAmount;

    private Date typeCreateDate;

    private char isActive;
}
