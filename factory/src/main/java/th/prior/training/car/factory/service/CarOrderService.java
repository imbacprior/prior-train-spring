package th.prior.training.car.factory.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import th.prior.training.car.factory.component.util.CarOrderTransformComponent;
import th.prior.training.car.factory.entity.CarEntity;
import th.prior.training.car.factory.entity.CarOrderEntity;
import th.prior.training.car.factory.model.CarModel;
import th.prior.training.car.factory.model.CarOrderModel;
import th.prior.training.car.factory.model.ErrorModel;
import th.prior.training.car.factory.model.ResponseModel;
import th.prior.training.car.factory.repository.CarOrderRepository;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class CarOrderService {

    private final CarOrderRepository carOrderRepository;

    private final CarOrderTransformComponent carOrderTransformComponent;

    public CarOrderService(CarOrderRepository carOrderRepository, CarOrderTransformComponent carOrderTransformComponent) {
        this.carOrderRepository = carOrderRepository;
        this.carOrderTransformComponent = carOrderTransformComponent;
    }

    public ResponseModel<Void> createCarOrder(CarOrderModel carOrderModel) {
        log.info("RequestBody: {}", carOrderModel);
        ResponseModel<Void> response = new ResponseModel<>();
        carOrderModel.setCarOrderDate(new Date());

        try {
            List<ErrorModel> errorModelList = this.carOrderTransformComponent.validateModel(carOrderModel);

            if (errorModelList.isEmpty()) {
                CarOrderEntity carOrderEntity = this.carOrderTransformComponent.transformModelToEntity(carOrderModel);
                this.carOrderRepository.save(carOrderEntity);
                response.setStatus(201);
                response.setDescription("created");
            } else {
                response.setStatus(501);
                response.setErrors(errorModelList);
                response.setDescription("some data invalid");
            }

        } catch (Exception e) {
            log.info("create CarOrder error {}", e.getMessage());
            response.setStatus(500);
            response.setDescription(e.getMessage());
        }

        return response;
    }

    public void deleteAll() {
        this.carOrderRepository.deleteAll();
    }
}
