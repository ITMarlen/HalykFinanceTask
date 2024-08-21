package kz.halykfinance.HalykFinanceTask.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "MESSAGE")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "BODY", nullable = false)
    @Lob
    private String body;
    @Column(name = "CREATED_DATE")
    @CreationTimestamp
    private LocalDateTime createdDate;
    @Column(name = "CLIENT_ID", nullable = false)
    private Long clientId;
}
