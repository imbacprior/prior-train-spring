package th.prior.training.car.showroom.model;

import lombok.Data;

import java.util.Date;

@Data
public class BuyerOrderModel {
    private int orderId;
    private String buyerName;
    private String orderStatus;
    private String orderCarType;
    private Date orderDate;
    private String isActive;
}
