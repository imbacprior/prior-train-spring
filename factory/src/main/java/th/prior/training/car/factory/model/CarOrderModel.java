package th.prior.training.car.factory.model;

import lombok.Data;

import java.util.Date;

@Data
public class CarOrderModel {

    private int orderId;
    private int carId;
    private Date carOrderDate;
    private char isActive;
}
