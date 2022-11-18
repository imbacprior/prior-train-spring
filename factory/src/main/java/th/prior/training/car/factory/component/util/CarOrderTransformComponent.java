package th.prior.training.car.factory.component.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import th.prior.training.car.factory.entity.CarOrderEntity;
import th.prior.training.car.factory.model.CarOrderModel;
import th.prior.training.car.factory.model.ErrorModel;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarOrderTransformComponent implements BaseTransformComponent<CarOrderModel, CarOrderEntity> {

    @Override
    public CarOrderModel transformEntityToModel(CarOrderEntity carOrderEntity) {
        CarOrderModel carOrderModel = new CarOrderModel();
        carOrderModel.setCarId(carOrderEntity.getCarId());
        carOrderModel.setCarOrderDate(carOrderEntity.getCarOrderDate());
        carOrderModel.setIsActive(carOrderEntity.getIsActive());

        return carOrderModel;
    }

    @Override
    public CarOrderEntity transformModelToEntity(CarOrderModel carOrderModel) {
        CarOrderEntity carOrderEntity = new CarOrderEntity();
        carOrderEntity.setCarId(carOrderModel.getCarId());
        carOrderEntity.setCarOrderDate(carOrderModel.getCarOrderDate());
        carOrderEntity.setIsActive(carOrderModel.getIsActive());

        return carOrderEntity;
    }

    @Override
    public List<ErrorModel> validateModel(CarOrderModel carOrderModel) {
        List<ErrorModel> errorModelList = new ArrayList<>();

        if (StringUtils.isEmpty(String.valueOf(carOrderModel.getCarId()))) {
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("0001");
            errorModel.setDescription("carId is empty");
            errorModelList.add(errorModel);
        }
        if (StringUtils.isEmpty(String.valueOf(carOrderModel.getIsActive()))) {
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("0001");
            errorModel.setDescription("isActive empty");
            errorModelList.add(errorModel);
        }

        return errorModelList;
    }

    @Override
    public String modelToJson(CarOrderModel carOrderModel) throws JsonProcessingException {
        return null;
    }

    @Override
    public CarOrderModel JsonToModel(String json) {
        return null;
    }
}
