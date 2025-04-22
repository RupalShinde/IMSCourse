package com.example.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	
	public List<Course> findAllByCategoryId(long categoryId);

}
