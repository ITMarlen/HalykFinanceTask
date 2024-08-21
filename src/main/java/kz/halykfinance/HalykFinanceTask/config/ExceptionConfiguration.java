package kz.halykfinance.HalykFinanceTask.config;

import kz.halykfinance.HalykFinanceTask.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import kz.halykfinance.HalykFinanceTask.exception.Error;

@ControllerAdvice
@Slf4j
public class ExceptionConfiguration {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Error> handleServiceException(CustomException ex) {
        Error error = new Error();
        error.setCode(Integer.toString(ex.getStatusCode()));
        error.setDescription(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.valueOf(ex.getStatusCode()));
    }
}
