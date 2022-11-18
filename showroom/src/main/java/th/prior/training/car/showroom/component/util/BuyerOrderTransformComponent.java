package th.prior.training.car.showroom.component.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import th.prior.training.car.showroom.entity.BuyerOrderEntity;
import th.prior.training.car.showroom.model.BuyerOrderModel;
import th.prior.training.car.showroom.model.ErrorModel;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuyerOrderTransformComponent implements BaseTransformComponent<BuyerOrderModel, BuyerOrderEntity> {

    @Override
    public BuyerOrderModel transformEntityToModel(BuyerOrderEntity buyerOrderEntity) {
        BuyerOrderModel buyerOrderModel = new BuyerOrderModel();
        buyerOrderModel.setBuyerName(buyerOrderEntity.getBuyerName());
        buyerOrderModel.setOrderDate(buyerOrderEntity.getOrderDate());
        buyerOrderModel.setOrderStatus(buyerOrderEntity.getOrderStatus());
        buyerOrderModel.setOrderCarType(buyerOrderEntity.getOrderCarType());
        buyerOrderModel.setIsActive(buyerOrderEntity.getIsActive());

        return buyerOrderModel;
    }

    @Override
    public BuyerOrderEntity transformModelToEntity(BuyerOrderModel buyerOrderModel) {
        BuyerOrderEntity buyerOrderEntity = new BuyerOrderEntity();
        buyerOrderEntity.setBuyerName(buyerOrderModel.getBuyerName());
        buyerOrderEntity.setOrderDate(buyerOrderModel.getOrderDate());
        buyerOrderEntity.setOrderStatus(buyerOrderModel.getOrderStatus());
        buyerOrderEntity.setOrderCarType(buyerOrderModel.getOrderCarType());
        buyerOrderEntity.setIsActive(buyerOrderModel.getIsActive());

        return buyerOrderEntity;
    }

    @Override
    public List<ErrorModel> validateModel(BuyerOrderModel buyerOrderModel) {
        List<ErrorModel> errorModelList = new ArrayList<>();

        if (StringUtils.isEmpty(buyerOrderModel.getBuyerName())) {
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("0001");
            errorModel.setDescription("buyerName is empty");
            errorModelList.add(errorModel);
        }
        if (StringUtils.isEmpty(buyerOrderModel.getOrderStatus())) {
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("0001");
            errorModel.setDescription("orderStatus is empty");
            errorModelList.add(errorModel);
        }
        if (StringUtils.isEmpty(buyerOrderModel.getOrderCarType())) {
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("0001");
            errorModel.setDescription("orderCarType is empty");
            errorModelList.add(errorModel);
        }
        if (StringUtils.isEmpty(buyerOrderModel.getIsActive())) {
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("0001");
            errorModel.setDescription("isActive is empty");
            errorModelList.add(errorModel);
        }
        return errorModelList;
    }

    @Override
    public String modelToJson(BuyerOrderModel buyerOrderModel) throws JsonProcessingException {
        return null;
    }

    @Override
    public BuyerOrderModel JsonToModel(String json) {
        return null;
    }
}
