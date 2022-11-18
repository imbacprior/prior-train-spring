package th.prior.training.car.factory.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import th.prior.training.car.factory.component.util.TypeCarInfoTransformComponent;
import th.prior.training.car.factory.entity.CarPartEntity;
import th.prior.training.car.factory.entity.TypeCarInfoEntity;
import th.prior.training.car.factory.model.CarPartModel;
import th.prior.training.car.factory.model.ErrorModel;
import th.prior.training.car.factory.model.ResponseModel;
import th.prior.training.car.factory.model.TypeCarInfoModel;
import th.prior.training.car.factory.repository.TypeCarInfoRepository;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class TypeCarInfoService {

    private final TypeCarInfoRepository typeCarInfoRepository;

    private final TypeCarInfoTransformComponent typeCarInfoTransformComponent;

    public TypeCarInfoService(TypeCarInfoRepository typeCarInfoRepository, TypeCarInfoTransformComponent typeCarInfoTransformComponent) {
        this.typeCarInfoRepository = typeCarInfoRepository;
        this.typeCarInfoTransformComponent = typeCarInfoTransformComponent;
    }

    public ResponseModel<Void> createTypeCarInfo(TypeCarInfoModel typeCarInfoModel) {
        log.info("RequestBody: {}", typeCarInfoModel);
        ResponseModel<Void> response = new ResponseModel<>();
        typeCarInfoModel.setTypeCreateDate(new Date());

        try {
            List<ErrorModel> errorModelList = this.typeCarInfoTransformComponent.validateModel(typeCarInfoModel);

            if (errorModelList.isEmpty()) {
                TypeCarInfoEntity typeCarInfoEntity = this.typeCarInfoTransformComponent.transformModelToEntity(typeCarInfoModel);
                this.typeCarInfoRepository.save(typeCarInfoEntity);
                response.setStatus(201);
                response.setDescription("created");
            } else {
                response.setStatus(501);
                response.setErrors(errorModelList);
                response.setDescription("some data invalid");
            }

        } catch (Exception e) {
            log.info("create TypeCarInfo error {}", e.getMessage());
            response.setStatus(500);
            response.setDescription(e.getMessage());
        }

        return response;
    }

    public void deleteAll() {
        this.typeCarInfoRepository.deleteAll();
    }
}
