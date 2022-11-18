package th.prior.training.car.factory.component.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import th.prior.training.car.factory.entity.CarPartEntity;
import th.prior.training.car.factory.model.CarPartModel;
import th.prior.training.car.factory.model.ErrorModel;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarPartTransformComponent implements BaseTransformComponent<CarPartModel, CarPartEntity> {

    @Override
    public CarPartModel transformEntityToModel(CarPartEntity carPartEntity) {
        CarPartModel carPartModel = new CarPartModel();
        carPartModel.setPartName(carPartEntity.getPartName());
        carPartModel.setCarId(carPartEntity.getCarId());
        carPartModel.setPartCreateDate(carPartEntity.getPartCreateDate());

        return carPartModel;
    }

    @Override
    public CarPartEntity transformModelToEntity(CarPartModel carPartModel) {
        CarPartEntity carPartEntity = new CarPartEntity();
        carPartEntity.setPartName(carPartModel.getPartName());
        carPartEntity.setCarId(carPartModel.getCarId());
        carPartEntity.setPartCreateDate(carPartModel.getPartCreateDate());

        return carPartEntity;
    }

    @Override
    public List<ErrorModel> validateModel(CarPartModel carPartModel) {
        List<ErrorModel> errorModelList = new ArrayList<>();

        if (StringUtils.isEmpty(carPartModel.getPartName())) {
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("0001");
            errorModel.setDescription("partName is empty");
            errorModelList.add(errorModel);
        }
        if (StringUtils.isEmpty(String.valueOf(carPartModel.getCarId()))) {
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("0001");
            errorModel.setDescription("carId is empty");
            errorModelList.add(errorModel);
        }
        if (StringUtils.isEmpty(String.valueOf(carPartModel.getPartCreateDate()))) {
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("0001");
            errorModel.setDescription("partCreateDate is empty");
            errorModelList.add(errorModel);
        }

        return errorModelList;
    }

    @Override
    public String modelToJson(CarPartModel carPartModel) throws JsonProcessingException {
        return null;
    }

    @Override
    public CarPartModel JsonToModel(String json) {
        return null;
    }
}
