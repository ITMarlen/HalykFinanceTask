package kz.halykfinance.HalykFinanceTask.json;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientJson {
    private Long id;
    private String login;
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private LocalDate createdDate;
    private LocalDate updatedDate;
}
