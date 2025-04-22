package com.example.course.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class CourseDTO {

    private Long id;

    private String title;
    private String description;
    private BigDecimal price;
    private int duration;
    private String thumbnailUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private long categoryId;

//    private List<CourseSubscriptionDTO> subscriptions;

}

