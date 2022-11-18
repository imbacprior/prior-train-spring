package th.prior.training.car.factory.component.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import th.prior.training.car.factory.entity.TypeCarInfoEntity;
import th.prior.training.car.factory.model.ErrorModel;
import th.prior.training.car.factory.model.TypeCarInfoModel;

import java.util.ArrayList;
import java.util.List;

@Component
public class TypeCarInfoTransformComponent implements BaseTransformComponent<TypeCarInfoModel, TypeCarInfoEntity> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public TypeCarInfoModel transformEntityToModel(TypeCarInfoEntity typeCarInfoEntity) {
        TypeCarInfoModel typeCarInfoModel = new TypeCarInfoModel();
        typeCarInfoModel.setTypeGroup(typeCarInfoEntity.getTypeGroup());
        typeCarInfoModel.setTypePart(typeCarInfoEntity.getTypePart());
        typeCarInfoModel.setTypeAmount(typeCarInfoEntity.getTypeAmount());
        typeCarInfoModel.setTypeCreateDate(typeCarInfoEntity.getTypeCreateDate());
        typeCarInfoModel.setIsActive(typeCarInfoEntity.getIsActive());

        return typeCarInfoModel;
    }

    @Override
    public TypeCarInfoEntity transformModelToEntity(TypeCarInfoModel typeCarInfoModel) {
        TypeCarInfoEntity typeCarInfoEntity = new TypeCarInfoEntity();
        typeCarInfoEntity.setTypeGroup(typeCarInfoModel.getTypeGroup());
        typeCarInfoEntity.setTypePart(typeCarInfoModel.getTypePart());
        typeCarInfoEntity.setTypeAmount(typeCarInfoModel.getTypeAmount());
        typeCarInfoEntity.setTypeCreateDate(typeCarInfoModel.getTypeCreateDate());
        typeCarInfoEntity.setIsActive(typeCarInfoModel.getIsActive());

        return typeCarInfoEntity;
    }

    @Override
    public List<ErrorModel> validateModel(TypeCarInfoModel typeCarInfoModel) {
        List<ErrorModel> errorModelList = new ArrayList<>();

        if (StringUtils.isEmpty(typeCarInfoModel.getTypeGroup())) {
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("0001");
            errorModel.setDescription("typeGroup is empty");
            errorModelList.add(errorModel);
        }
        if (StringUtils.isEmpty(typeCarInfoModel.getTypePart())) {
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("0001");
            errorModel.setDescription("typePart is empty");
            errorModelList.add(errorModel);
        }
        if (StringUtils.isEmpty(String.valueOf(typeCarInfoModel.getTypeAmount()))) {
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("0001");
            errorModel.setDescription("typeAmount is empty");
            errorModelList.add(errorModel);
        }
        if (StringUtils.isEmpty(String.valueOf(typeCarInfoModel.getIsActive()))) {
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("0001");
            errorModel.setDescription("isActive is empty");
            errorModelList.add(errorModel);
        }

        return errorModelList;
    }

    @Override
    public String modelToJson(TypeCarInfoModel typeCarInfoModel) throws JsonProcessingException {
        return this.objectMapper.writeValueAsString(typeCarInfoModel);
    }

    @Override
    public TypeCarInfoModel JsonToModel(String json) {
        return null;
    }
}
