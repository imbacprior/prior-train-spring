package th.prior.training.car.showroom.restcontroller;

import org.springframework.web.bind.annotation.*;
import th.prior.training.car.showroom.model.BuyerNotiModel;
import th.prior.training.car.showroom.model.ResponseModel;
import th.prior.training.car.showroom.service.BuyerNotiService;

@RestController
@RequestMapping("/api/buyer-noti")
public class BuyerNotiRestController {

    private final BuyerNotiService buyerNotiService;

    public BuyerNotiRestController(BuyerNotiService buyerNotiService) {
        this.buyerNotiService = buyerNotiService;
    }

    @PostMapping("/create")
    public ResponseModel<Void> createBuyerNoti(@RequestBody BuyerNotiModel buyerNotiModel) {
        return this.buyerNotiService.createBuyerNoti(buyerNotiModel);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllBuyerNoti() {
        this.buyerNotiService.deleteAll();
    }
}
