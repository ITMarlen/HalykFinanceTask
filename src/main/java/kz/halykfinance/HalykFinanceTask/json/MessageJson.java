package kz.halykfinance.HalykFinanceTask.json;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageJson {
    private Long id;
    private String clientLogin;
    private String body;
    private LocalDateTime createdDate;
}
