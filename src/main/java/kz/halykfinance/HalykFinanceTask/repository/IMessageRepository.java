package kz.halykfinance.HalykFinanceTask.repository;

import kz.halykfinance.HalykFinanceTask.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMessageRepository extends JpaRepository<MessageEntity, Long> {
}
