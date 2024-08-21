package kz.halykfinance.HalykFinanceTask.repository;

import kz.halykfinance.HalykFinanceTask.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClientRepository extends JpaRepository<ClientEntity, Long> {
    Optional<ClientEntity> findByLogin(String login);
}
