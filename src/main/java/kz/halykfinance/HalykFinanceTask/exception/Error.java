package kz.halykfinance.HalykFinanceTask.exception;

import lombok.Data;

import java.util.StringJoiner;

@Data
public class Error {
    private String code;
    private String description;

    @Override
    public String toString() {
        return new StringJoiner(", ", Error.class.getSimpleName() + "[", "]")
                .add("code='" + code + "'")
                .add("description='" + description + "'")
                .toString();
    }
}
