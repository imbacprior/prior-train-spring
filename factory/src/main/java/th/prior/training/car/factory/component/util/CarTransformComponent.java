package th.prior.training.car.factory.component.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import th.prior.training.car.factory.entity.CarEntity;
import th.prior.training.car.factory.model.CarModel;
import th.prior.training.car.factory.model.ErrorModel;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarTransformComponent implements BaseTransformComponent<CarModel, CarEntity> {

    @Override
    public CarModel transformEntityToModel(CarEntity carEntity) {
        CarModel carModel = new CarModel();
        carModel.setCarCreateDate(carEntity.getCarCreateDate());
        return carModel;
    }

    @Override
    public CarEntity transformModelToEntity(CarModel carModel) {
        CarEntity carEntity = new CarEntity();
        carEntity.setCarCreateDate(carModel.getCarCreateDate());
        return carEntity;
    }

    @Override
    public List<ErrorModel> validateModel(CarModel carModel) {
        return null;
    }

    @Override
    public String modelToJson(CarModel carModel) throws JsonProcessingException {
        return null;
    }

    @Override
    public CarModel JsonToModel(String json) {
        return null;
    }
}
