package kz.halykfinance.HalykFinanceTask.service;

import kz.halykfinance.HalykFinanceTask.dto.ClientDto;

public interface IClientService {
    ClientDto createClient(ClientDto clientDto);
}
