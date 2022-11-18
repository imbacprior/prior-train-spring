package th.prior.training.car.showroom.component.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import th.prior.training.car.showroom.entity.BuyerNotiEntity;
import th.prior.training.car.showroom.model.BuyerNotiModel;
import th.prior.training.car.showroom.model.ErrorModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class BuyerNotiTransformComponent implements BaseTransformComponent<BuyerNotiModel, BuyerNotiEntity> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public BuyerNotiModel transformEntityToModel(BuyerNotiEntity buyerNotiEntity) {
        BuyerNotiModel buyerNotiModel = new BuyerNotiModel();
        buyerNotiModel.setOrderId(buyerNotiEntity.getOrderId());
        buyerNotiModel.setNotiCode(buyerNotiEntity.getNotiCode());
        buyerNotiModel.setNotiDescription(buyerNotiEntity.getNotiDescription());
        buyerNotiModel.setNotiDate(buyerNotiEntity.getNotiDate());

        return buyerNotiModel;
    }

    @Override
    public BuyerNotiEntity transformModelToEntity(BuyerNotiModel buyerNotiModel) {
        BuyerNotiEntity buyerNotiEntity = new BuyerNotiEntity();
        buyerNotiEntity.setOrderId(buyerNotiModel.getOrderId());
        buyerNotiEntity.setNotiCode(buyerNotiModel.getNotiCode());
        buyerNotiEntity.setNotiDescription(buyerNotiModel.getNotiDescription());
        buyerNotiEntity.setNotiDate(buyerNotiModel.getNotiDate());

        return buyerNotiEntity;
    }

    @Override
    public List<ErrorModel> validateModel(BuyerNotiModel buyerNotiModel) {
        List<ErrorModel> errorModelList = new ArrayList<>();

        if (StringUtils.isEmpty(String.valueOf(buyerNotiModel.getOrderId()))) {
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("0001");
            errorModel.setDescription("orderId is empty");
            errorModelList.add(errorModel);
        }
        if (StringUtils.isEmpty(buyerNotiModel.getNotiCode())) {
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("0001");
            errorModel.setDescription("notiCode is empty");
            errorModelList.add(errorModel);
        }
        if (StringUtils.isEmpty(buyerNotiModel.getNotiDescription())) {
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("0001");
            errorModel.setDescription("notiDescription is empty");
            errorModelList.add(errorModel);
        }

        return errorModelList;
    }

    @Override
    public String modelToJson(BuyerNotiModel buyerNotiModel) throws JsonProcessingException {
        return this.objectMapper.writeValueAsString(buyerNotiModel);
    }

    @Override
    public BuyerNotiModel JsonToModel(String json) {
        return null;
    }
}
