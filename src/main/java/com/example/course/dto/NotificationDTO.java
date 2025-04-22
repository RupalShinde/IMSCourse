package com.example.course.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class NotificationDTO {
	private Long id;
    private Integer userId;
    private Integer categoryId;
    private String type; // e.g., "user", "subscriber", "all"
    private String title;
    private String message;
    private Boolean isSent = false;
    private String status; // e.g., "pending", "sent", "failed"
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
