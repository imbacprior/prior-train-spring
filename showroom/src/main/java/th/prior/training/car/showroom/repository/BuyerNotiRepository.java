package th.prior.training.car.showroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.prior.training.car.showroom.entity.BuyerNotiEntity;

@Repository
public interface BuyerNotiRepository extends JpaRepository<BuyerNotiEntity, Integer> {
}
