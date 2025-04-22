package com.example.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.model.Testimonial;

public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {

}


