package com.example.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
