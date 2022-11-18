package th.prior.training.car.factory.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "car_order")
@Data
public class CarOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private int carId;

    private Date carOrderDate;

    private char isActive;
}
