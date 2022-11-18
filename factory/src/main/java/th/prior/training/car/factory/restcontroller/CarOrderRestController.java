package th.prior.training.car.factory.restcontroller;

import org.springframework.web.bind.annotation.*;
import th.prior.training.car.factory.model.CarModel;
import th.prior.training.car.factory.model.CarOrderModel;
import th.prior.training.car.factory.model.ResponseModel;
import th.prior.training.car.factory.service.CarOrderService;

@RestController
@RequestMapping("/api/car-order")
public class CarOrderRestController {

    private final CarOrderService carOrderService;

    public CarOrderRestController(CarOrderService carOrderService) {
        this.carOrderService = carOrderService;
    }

    @PostMapping("/create")
    public ResponseModel<Void> createCar(@RequestBody CarOrderModel carOrderModel) {
        return this.carOrderService.createCarOrder(carOrderModel);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllCar() {
        this.carOrderService.deleteAll();
    }
}
