package kz.halykfinance.HalykFinanceTask.dao;

import jakarta.transaction.Transactional;
import kz.halykfinance.HalykFinanceTask.entity.MessageEntity;
import kz.halykfinance.HalykFinanceTask.repository.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class MessageDao {
    @Autowired
    private IMessageRepository messageRepository;

    public MessageEntity save(MessageEntity messageEntity) {
        return messageRepository.save(messageEntity);
    }
}
