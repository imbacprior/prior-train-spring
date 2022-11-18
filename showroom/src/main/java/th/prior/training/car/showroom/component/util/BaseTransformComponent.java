package th.prior.training.car.showroom.component.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import th.prior.training.car.showroom.model.ErrorModel;

import java.util.List;

public interface BaseTransformComponent<M, E>{

    public M transformEntityToModel(E e);

    public E transformModelToEntity(M m);

    public List<ErrorModel> validateModel(M m);

//    public void updateEntityByModel(E e, M m);


    public String modelToJson(M m) throws JsonProcessingException;

    public M JsonToModel(String json);
}
