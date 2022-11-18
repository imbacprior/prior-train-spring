package th.prior.training.car.factory.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import th.prior.training.car.factory.component.util.CarTransformComponent;
import th.prior.training.car.factory.entity.CarEntity;
import th.prior.training.car.factory.model.CarModel;
import th.prior.training.car.factory.model.ResponseModel;
import th.prior.training.car.factory.repository.CarRepository;

import java.util.Date;

@Slf4j
@Service
public class CarService {

    private final CarRepository carRepository;

    private final CarTransformComponent carTransformComponent;

    public CarService(CarRepository carRepository, CarTransformComponent carTransformComponent) {
        this.carRepository = carRepository;
        this.carTransformComponent = carTransformComponent;
    }

    public ResponseModel<Void> createCar(CarModel carModel) {
        log.info("RequestBody: {}", carModel);
        ResponseModel<Void> response = new ResponseModel<>();
        carModel.setCarCreateDate(new Date());

        try {
            CarEntity carEntity = this.carTransformComponent.transformModelToEntity(carModel);
            this.carRepository.save(carEntity);
            response.setStatus(201);
            response.setDescription("created");
        } catch (Exception e) {
            log.info("create Car error {}", e.getMessage());
            response.setStatus(500);
            response.setDescription(e.getMessage());
        }

        return response;
    }

    public void deleteAll() {
        this.carRepository.deleteAll();
    }
}
