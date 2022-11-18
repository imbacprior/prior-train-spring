package th.prior.training.car.showroom.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import th.prior.training.car.showroom.component.util.BuyerNotiTransformComponent;
import th.prior.training.car.showroom.entity.BuyerNotiEntity;
import th.prior.training.car.showroom.model.BuyerNotiModel;
import th.prior.training.car.showroom.model.ErrorModel;
import th.prior.training.car.showroom.model.ResponseModel;
import th.prior.training.car.showroom.repository.BuyerNotiRepository;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class BuyerNotiService {

    private final BuyerNotiRepository buyerNotiRepository;

    private final BuyerNotiTransformComponent buyerNotiTransformComponent;

    public BuyerNotiService(BuyerNotiRepository buyerNotiRepository, BuyerNotiTransformComponent buyerNotiTransformComponent) {
        this.buyerNotiRepository = buyerNotiRepository;
        this.buyerNotiTransformComponent = buyerNotiTransformComponent;
    }

    public ResponseModel<Void> createBuyerNoti(BuyerNotiModel buyerNotiModel) {
        log.info("RequestBody: {}", buyerNotiModel);
        ResponseModel<Void> response = new ResponseModel<>();
        buyerNotiModel.setNotiDate(new Date());

        try {
            List<ErrorModel> errorModelList = this.buyerNotiTransformComponent.validateModel(buyerNotiModel);

            if (errorModelList.isEmpty()) {
                BuyerNotiEntity buyerNotiEntity = this.buyerNotiTransformComponent.transformModelToEntity(buyerNotiModel);
                this.buyerNotiRepository.save(buyerNotiEntity);
                response.setStatus(201);
                response.setDescription("created");
            } else {
                response.setStatus(501);
                response.setErrors(errorModelList);
                response.setDescription("some data invalid");
            }

        } catch (Exception e) {
            log.info("create BuyerOrder error {}", e.getMessage());
            response.setStatus(500);
            response.setDescription(e.getMessage());
        }

        return response;
    }

    public void deleteAll() {
        this.buyerNotiRepository.deleteAll();
    }
}
