package th.prior.training.car.factory.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import th.prior.training.car.factory.component.util.CarPartTransformComponent;
import th.prior.training.car.factory.entity.CarOrderEntity;
import th.prior.training.car.factory.entity.CarPartEntity;
import th.prior.training.car.factory.model.CarOrderModel;
import th.prior.training.car.factory.model.CarPartModel;
import th.prior.training.car.factory.model.ErrorModel;
import th.prior.training.car.factory.model.ResponseModel;
import th.prior.training.car.factory.repository.CarPartRepository;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class CarPartService {

    private final CarPartRepository carPartRepository;

    private final CarPartTransformComponent carPartTransformComponent;

    public CarPartService(CarPartRepository carPartRepository, CarPartTransformComponent carPartTransformComponent) {
        this.carPartRepository = carPartRepository;
        this.carPartTransformComponent = carPartTransformComponent;
    }

    public ResponseModel<Void> createCarPart(CarPartModel carPartModel) {
        log.info("RequestBody: {}", carPartModel);
        ResponseModel<Void> response = new ResponseModel<>();
        carPartModel.setPartCreateDate(new Date());

        try {
            List<ErrorModel> errorModelList = this.carPartTransformComponent.validateModel(carPartModel);

            if (errorModelList.isEmpty()) {
                CarPartEntity carPartEntity = this.carPartTransformComponent.transformModelToEntity(carPartModel);
                this.carPartRepository.save(carPartEntity);
                response.setStatus(201);
                response.setDescription("created");
            } else {
                response.setStatus(501);
                response.setErrors(errorModelList);
                response.setDescription("some data invalid");
            }

        } catch (Exception e) {
            log.info("create CarPart error {}", e.getMessage());
            response.setStatus(500);
            response.setDescription(e.getMessage());
        }

        return response;
    }

    public void deleteAll() {
        this.carPartRepository.deleteAll();
    }
}
