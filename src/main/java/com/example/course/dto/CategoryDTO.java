package com.example.course.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.course.model.Notification;

import lombok.Data;

@Data
public class CategoryDTO {
	private Long id;

    private String name;
    private String description;
    private String iconBase64;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

//    private List<Course> courses;

//    private List<NotificationDTO> notifications;

}
