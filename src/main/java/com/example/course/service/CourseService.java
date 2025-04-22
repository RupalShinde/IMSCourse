package com.example.course.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.dto.CourseDTO;
import com.example.course.model.Course;
import com.example.course.repository.CourseRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CourseService {
		
	@Autowired
    private CourseRepository courseRepository;
	
	private final ModelMapper modelMapper = new ModelMapper();
	
    public CourseDTO convertToDTO(Course course) {
        return modelMapper.map(course, CourseDTO.class);
    }
    
    public Course convertToEntity(CourseDTO courseDTO) {
        return modelMapper.map(courseDTO, Course.class);
    }


    public Course createOrUpdateCourse(CourseDTO courseDTO) {
    	return courseRepository.save(convertToEntity(courseDTO)); 
    }
    
    public List<CourseDTO> getAllCourse() {
    	List<Course> courses =courseRepository.findAll(); // Fetch all users
        return courses.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public void deleteCourseById(long id) {
    	
    	courseRepository.findById(id).ifPresentOrElse(course -> {
    	    if (!course.getSubscriptions().isEmpty()) {
    	        throw new IllegalStateException("Cannot delete course with active subscriptions.");
    	    }
    	    courseRepository.deleteById(id);
    	}, () -> {
    	    throw new EntityNotFoundException("Course with ID " + id + " not found.");
    	});

    }
    
    public List<CourseDTO> getCourseByCategoryId(long categoryId) {
    	List<Course> Course = courseRepository.findAllByCategoryId(categoryId);
        return Course.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

	
}
