package kz.halykfinance.HalykFinanceTask.dao;

import jakarta.transaction.Transactional;
import kz.halykfinance.HalykFinanceTask.entity.ClientEntity;
import kz.halykfinance.HalykFinanceTask.exception.CustomException;
import kz.halykfinance.HalykFinanceTask.exception.ErrorEnum;
import kz.halykfinance.HalykFinanceTask.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public class ClientDao {
    @Autowired
    private IClientRepository clientRepository;

    public ClientEntity save(ClientEntity clientEntity){
        Optional<ClientEntity> optionalClientEntity = clientRepository.findByLogin(clientEntity.getLogin());
        if (optionalClientEntity.isPresent()) {
            throw new CustomException(ErrorEnum.CLIENT_EXIST);
        }
        return clientRepository.save(clientEntity);
    }

    public ClientEntity findByLogin(String login){
        Optional<ClientEntity> optionalClientEntity = clientRepository.findByLogin(login);
        if (!optionalClientEntity.isPresent()) {
            throw new CustomException(ErrorEnum.CLIENT_NOT_FOUND);
        }
        return optionalClientEntity.get();
    }
}
