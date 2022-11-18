package th.prior.training.car.factory.model;

import lombok.Data;

import java.util.List;

@Data
public class ResponseModel<T> {
    private int status;
    private String description;
    private List<ErrorModel> errors;
    private T data;
}
