package com.example.course.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.course.model.CustomerServiceChat;

import lombok.Data;

@Data
public class UserDTO {

	private Long id;

    private String userType;
    private String name;
    private String phoneNumber;
    private String email;
    private String state;

    private LocalDateTime lastLoggedOn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Relationships
    private List<NotificationDTO> notifications;
    private List<CourseSubscriptionDTO> subscriptions;
    private List<TransactionDTO> transactions;
    private List<CustomerServiceChat> chats;

}
