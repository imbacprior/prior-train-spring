package th.prior.training.car.factory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.prior.training.car.factory.entity.CarPartEntity;

@Repository
public interface CarPartRepository extends JpaRepository<CarPartEntity, Integer> {
}
