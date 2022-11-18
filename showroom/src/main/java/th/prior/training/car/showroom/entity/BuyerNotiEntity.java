package th.prior.training.car.showroom.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "buyer_notification")
@Data
public class BuyerNotiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notiId;

    private int orderId;

    private String notiCode;

    private String notiDescription;

    private Date notiDate;
}
