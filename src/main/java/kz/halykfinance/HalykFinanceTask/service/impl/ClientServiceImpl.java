package kz.halykfinance.HalykFinanceTask.service.impl;

import kz.halykfinance.HalykFinanceTask.annotation.CustomLogging;
import kz.halykfinance.HalykFinanceTask.dao.ClientDao;
import kz.halykfinance.HalykFinanceTask.dto.ClientDto;
import kz.halykfinance.HalykFinanceTask.entity.ClientEntity;
import kz.halykfinance.HalykFinanceTask.mapping.ClientMapper;
import kz.halykfinance.HalykFinanceTask.service.IClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClientServiceImpl implements IClientService {
    @Autowired
    private ClientDao clientDao;
    @Autowired
    private ClientMapper clientMapper;
    @Override
    @CustomLogging
    public ClientDto createClient(ClientDto clientDto){
        ClientEntity clientEntity = clientDao.save(clientMapper.toEntity(clientDto));
        return clientMapper.toDto(clientEntity);
    }
}
