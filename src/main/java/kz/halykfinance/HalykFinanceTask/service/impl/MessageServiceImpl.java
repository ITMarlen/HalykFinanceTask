package kz.halykfinance.HalykFinanceTask.service.impl;

import kz.halykfinance.HalykFinanceTask.annotation.CustomLogging;
import kz.halykfinance.HalykFinanceTask.dao.ClientDao;
import kz.halykfinance.HalykFinanceTask.dto.MessageDto;
import kz.halykfinance.HalykFinanceTask.entity.ClientEntity;
import kz.halykfinance.HalykFinanceTask.service.IMessageQueueService;
import kz.halykfinance.HalykFinanceTask.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageServiceImpl implements IMessageService {
    @Autowired
    private IMessageQueueService messageQueueService;
    @Autowired
    private ClientDao clientDao;
    @Override
    @CustomLogging
    public void sendMessage(MessageDto messageDto) {
        ClientEntity clientEntity = clientDao.findByLogin(messageDto.getClientLogin());
        messageDto.setClientId(clientEntity.getId());
        messageQueueService.enqueueMessage(messageDto);
    }
}
