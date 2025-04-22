package com.example.course.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TestimonialDTO {
	private Long id;
    private int rating;
    private String review;
    private boolean active = true;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt; 
}
