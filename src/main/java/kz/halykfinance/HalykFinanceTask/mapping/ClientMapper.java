package kz.halykfinance.HalykFinanceTask.mapping;

import kz.halykfinance.HalykFinanceTask.dto.ClientDto;
import kz.halykfinance.HalykFinanceTask.entity.ClientEntity;
import kz.halykfinance.HalykFinanceTask.json.ClientJson;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface ClientMapper {
    ClientDto toDto(ClientJson clientJson);
    ClientDto toDto(ClientEntity clientEntity);
    ClientJson toJson(ClientDto clientDto);
    ClientEntity toEntity(ClientDto clientDto);
}
