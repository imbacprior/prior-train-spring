package th.prior.training.car.showroom.model;

import lombok.Data;

import java.util.Date;

@Data
public class BuyerNotiModel {
    private int notiId;
    private int orderId;
    private String notiCode;
    private String notiDescription;
    private Date notiDate;
}
