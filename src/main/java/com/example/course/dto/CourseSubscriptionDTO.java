package com.example.course.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CourseSubscriptionDTO {

   
    private Long id;

    private LocalDateTime subscriptionDate;
    private LocalDateTime expirationDate;
    private String status;
    private String subscriptionType;
    private String paymentId;
    private BigDecimal price;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    
    private UserDTO user;

//    private Course course;

    // Getters and Setters
}
