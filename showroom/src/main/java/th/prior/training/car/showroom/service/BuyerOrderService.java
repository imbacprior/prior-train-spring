package th.prior.training.car.showroom.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import th.prior.training.car.showroom.component.util.BuyerOrderTransformComponent;
import th.prior.training.car.showroom.entity.BuyerOrderEntity;
import th.prior.training.car.showroom.kafka.component.KafkaProducerComponent;
import th.prior.training.car.showroom.model.BuyerOrderModel;
import th.prior.training.car.showroom.model.ErrorModel;
import th.prior.training.car.showroom.model.ResponseModel;
import th.prior.training.car.showroom.repository.BuyerOrderRepository;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class BuyerOrderService {

    private final BuyerOrderRepository buyerOrderRepository;

    private final BuyerOrderTransformComponent buyerOrderTransformComponent;

    private final KafkaProducerComponent kafkaProducerComponent;

    @Value("${app.kafka.topics.is-ready}")
    private String isReadyTopic;

    public BuyerOrderService(BuyerOrderRepository buyerOrderRepository, BuyerOrderTransformComponent buyerOrderTransformComponent, KafkaProducerComponent kafkaProducerComponent) {
        this.buyerOrderRepository = buyerOrderRepository;
        this.buyerOrderTransformComponent = buyerOrderTransformComponent;
        this.kafkaProducerComponent = kafkaProducerComponent;
    }

    public ResponseModel<Void> createBuyerOrder(BuyerOrderModel buyerOrderModel) {
        log.info("RequestBody: {}", buyerOrderModel);
        ResponseModel<Void> response = new ResponseModel<>();
        buyerOrderModel.setOrderDate(new Date());

        try {
            List<ErrorModel> errorModelList = this.buyerOrderTransformComponent.validateModel(buyerOrderModel);

            if (errorModelList.isEmpty()) {
                BuyerOrderEntity buyerOrderEntity = this.buyerOrderTransformComponent.transformModelToEntity(buyerOrderModel);
                this.buyerOrderRepository.save(buyerOrderEntity);
                response.setStatus(201);
                response.setDescription("created");
                this.kafkaProducerComponent
                        .send("BuyerOrder is created.", isReadyTopic);
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
        this.buyerOrderRepository.deleteAll();
    }
}
