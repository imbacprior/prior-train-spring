package th.prior.training.car.factory.restcontroller;

import org.springframework.web.bind.annotation.*;
import th.prior.training.car.factory.model.CarOrderModel;
import th.prior.training.car.factory.model.CarPartModel;
import th.prior.training.car.factory.model.ResponseModel;
import th.prior.training.car.factory.service.CarPartService;

@RestController
@RequestMapping("/api/car-part")
public class CarPartRestController {

    private final CarPartService carPartService;

    public CarPartRestController(CarPartService carPartService) {
        this.carPartService = carPartService;
    }

    @PostMapping("/create")
    public ResponseModel<Void> createCar(@RequestBody CarPartModel carPartModel) {
        return this.carPartService.createCarPart(carPartModel);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllCar() {
        this.carPartService.deleteAll();
    }
}
