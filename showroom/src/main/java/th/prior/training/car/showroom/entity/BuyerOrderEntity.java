package th.prior.training.car.showroom.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "buyer_order")
@Data
public class BuyerOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private String buyerName;

    private String orderStatus;

    private String orderCarType;

    private Date orderDate;

    private String isActive;
}
