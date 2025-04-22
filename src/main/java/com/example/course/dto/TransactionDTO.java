package com.example.course.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.course.model.User;

import lombok.Data;

@Data
public class TransactionDTO {
	private Long id;

    private LocalDateTime paymentDate;
    private String paymentMethod;
    private String transactionId;
    private BigDecimal amount;
    private String paymentStatus;
    private BigDecimal refundedAmount;
    private LocalDateTime refundedAt;
    private String paymentGatewayResponse;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private User user;
}
