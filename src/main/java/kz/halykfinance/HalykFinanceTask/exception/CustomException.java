package kz.halykfinance.HalykFinanceTask.exception;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
public class CustomException extends RuntimeException{
    private int statusCode;
    private String message;
    public CustomException(ErrorEnum errorEnum, String message) {
        this.statusCode = errorEnum.getStatus();
        this.message = message;
    }
    public CustomException(ErrorEnum errorEnum) {
        this.statusCode = errorEnum.getStatus();
        this.message = errorEnum.getMessage();
    }
}
