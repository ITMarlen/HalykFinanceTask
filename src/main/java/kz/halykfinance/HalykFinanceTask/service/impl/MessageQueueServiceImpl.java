package kz.halykfinance.HalykFinanceTask.service.impl;

import com.hazelcast.collection.IQueue;
import com.hazelcast.core.HazelcastInstance;
import kz.halykfinance.HalykFinanceTask.dto.MessageDto;
import kz.halykfinance.HalykFinanceTask.service.IMessageQueueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageQueueServiceImpl implements IMessageQueueService {
    @Autowired
    private HazelcastInstance hazelcastInstance;

    @Override
    public void enqueueMessage(MessageDto messageDto) {
        IQueue<MessageDto> queue = hazelcastInstance.getQueue("messageQueue");
        queue.offer(messageDto);
    }
}
