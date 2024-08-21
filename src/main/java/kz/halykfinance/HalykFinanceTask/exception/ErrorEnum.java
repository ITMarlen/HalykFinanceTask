package kz.halykfinance.HalykFinanceTask.exception;

import lombok.Getter;
import org.apache.hc.core5.http.HttpStatus;

@Getter
public enum ErrorEnum {
    RESOURCE_NOT_FOUND(HttpStatus.SC_NOT_FOUND, "No resource found"),
    BAD_REQUEST(HttpStatus.SC_BAD_REQUEST, "Bad Request"),
    CLIENT_EXIST(HttpStatus.SC_CONFLICT, "Client is already exist"),
    CLIENT_NOT_FOUND(HttpStatus.SC_NOT_FOUND, "Client not found");
    private final int status;
    private final String message;

    ErrorEnum(int status, String message) {
        this.status = status;
        this.message = message;
    }


}
