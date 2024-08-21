package kz.halykfinance.HalykFinanceTask.service;


import kz.halykfinance.HalykFinanceTask.dto.MessageDto;

public interface IMessageQueueService {
    void enqueueMessage(MessageDto messageDto);
}
