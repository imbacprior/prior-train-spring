package th.prior.training.car.factory.model;

import lombok.Data;

import java.util.Date;

@Data
public class TypeCarInfoModel {

    private int typeId;
    private String typeGroup;
    private String typePart;
    private int typeAmount;
    private Date typeCreateDate;
    private char isActive;
}
