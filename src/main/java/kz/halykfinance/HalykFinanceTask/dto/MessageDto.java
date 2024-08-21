package kz.halykfinance.HalykFinanceTask.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MessageDto implements Serializable {
    private Long id;
    private Long clientId;
    private String clientLogin;
    private String body;
    private LocalDateTime createdDate;
}
