package th.prior.training.car.factory.restcontroller;

import org.springframework.web.bind.annotation.*;
import th.prior.training.car.factory.model.CarModel;
import th.prior.training.car.factory.model.ResponseModel;
import th.prior.training.car.factory.service.CarService;

@RestController
@RequestMapping("/api/car")
public class CarRestController {

    private final CarService carService;

    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/create")
    public ResponseModel<Void> createCar(@RequestBody CarModel carModel) {
        return this.carService.createCar(carModel);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllCar() {
        this.carService.deleteAll();
    }
}
