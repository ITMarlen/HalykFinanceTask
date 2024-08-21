package kz.halykfinance.HalykFinanceTask.mapping;

import kz.halykfinance.HalykFinanceTask.dto.MessageDto;
import kz.halykfinance.HalykFinanceTask.entity.MessageEntity;
import kz.halykfinance.HalykFinanceTask.json.MessageJson;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface MessageMapper {
    MessageEntity toEntity(MessageDto messageDto);
    MessageDto toDto(MessageJson messageJson);
}
