package th.prior.training.car.factory.component.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import th.prior.training.car.factory.model.ErrorModel;

import java.util.List;

public interface BaseTransformComponent<M, E> {

    public M transformEntityToModel(E e);

    public E transformModelToEntity(M m);

    public List<ErrorModel> validateModel(M m);

    public String modelToJson(M m) throws JsonProcessingException;

    public M JsonToModel(String json);
}
