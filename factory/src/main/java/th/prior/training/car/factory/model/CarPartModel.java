package th.prior.training.car.factory.model;

import lombok.Data;

import java.util.Date;

@Data
public class CarPartModel {

    private int partId;
    private String partName;
    private int carId;
    private Date partCreateDate;
}
