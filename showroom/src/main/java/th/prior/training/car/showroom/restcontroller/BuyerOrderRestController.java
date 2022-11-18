package th.prior.training.car.showroom.restcontroller;

import org.springframework.web.bind.annotation.*;
import th.prior.training.car.showroom.entity.BuyerOrderEntity;
import th.prior.training.car.showroom.model.BuyerOrderModel;
import th.prior.training.car.showroom.model.ResponseModel;
import th.prior.training.car.showroom.service.BuyerOrderService;

@RestController
@RequestMapping("/api/buyer-order")
public class BuyerOrderRestController {

    private final BuyerOrderService buyerOrderService;

    public BuyerOrderRestController(BuyerOrderService buyerOrderService) {
        this.buyerOrderService = buyerOrderService;
    }

    @PostMapping("/create")
    public ResponseModel<Void> createBuyerOrder(@RequestBody BuyerOrderModel buyerOrderModel) {
        return this.buyerOrderService.createBuyerOrder(buyerOrderModel);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllBuyerOrder() {
        this.buyerOrderService.deleteAll();
    }
}
