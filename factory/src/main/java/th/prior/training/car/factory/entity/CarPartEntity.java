package th.prior.training.car.factory.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "car_part")
@Data
public class CarPartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int partId;

    private String partName;

    private int carId;

    private Date partCreateDate;
}
