package th.prior.training.car.factory.restcontroller;

import org.springframework.web.bind.annotation.*;
import th.prior.training.car.factory.model.CarPartModel;
import th.prior.training.car.factory.model.ResponseModel;
import th.prior.training.car.factory.model.TypeCarInfoModel;
import th.prior.training.car.factory.service.TypeCarInfoService;

@RestController
@RequestMapping("/api/type-car-info")
public class TypeCarInfoRestController {

    private final TypeCarInfoService typeCarInfoService;

    public TypeCarInfoRestController(TypeCarInfoService typeCarInfoService) {
        this.typeCarInfoService = typeCarInfoService;
    }

    @PostMapping("/create")
    public ResponseModel<Void> createCar(@RequestBody TypeCarInfoModel typeCarInfoModel) {
        return this.typeCarInfoService.createTypeCarInfo(typeCarInfoModel);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllCar() {
        this.typeCarInfoService.deleteAll();
    }
}
