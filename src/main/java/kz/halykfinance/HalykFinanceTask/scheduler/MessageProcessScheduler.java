package kz.halykfinance.HalykFinanceTask.scheduler;

import com.hazelcast.collection.IQueue;
import com.hazelcast.core.HazelcastInstance;
import kz.halykfinance.HalykFinanceTask.dao.MessageDao;
import kz.halykfinance.HalykFinanceTask.dto.MessageDto;
import kz.halykfinance.HalykFinanceTask.entity.MessageEntity;
import kz.halykfinance.HalykFinanceTask.mapping.MessageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageProcessScheduler {
    @Autowired
    private HazelcastInstance hazelcastInstance;
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private MessageMapper messageMapper;

    @Scheduled(fixedDelay = 1000)
    public void processMessages() {
        IQueue<MessageDto> queue = hazelcastInstance.getQueue("messageQueue");
        MessageDto messageDto;
        while ((messageDto = queue.poll()) != null) {
            MessageEntity messageEntity = messageMapper.toEntity(messageDto);
            messageDao.save(messageEntity);
        }
    }


}
