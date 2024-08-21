package kz.halykfinance.HalykFinanceTask.service;


import kz.halykfinance.HalykFinanceTask.dto.MessageDto;

public interface IMessageService {
    void sendMessage(MessageDto messageDto);
}
