package com.example.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.dto.CourseDTO;
import com.example.course.model.Course;
import com.example.course.service.CourseService;

@RestController
@RequestMapping("/Course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping
	public List<CourseDTO> getCourses() {
		return courseService.getAllCourse();
	}

	@PostMapping
	public ResponseEntity<Course> createOrUpdateCourse(@RequestBody CourseDTO Courses) {
		Course savedCourses = courseService.createOrUpdateCourse(Courses);
		return ResponseEntity.ok(savedCourses);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable long id, @RequestBody CourseDTO CoursesDTO) {
		CoursesDTO.setId(id); 
		Course updatedUser = courseService.createOrUpdateCourse(CoursesDTO); 
	    return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCourses(@PathVariable int id) {
		courseService.deleteCourseById(id);
	    return ResponseEntity.ok("Courses with ID " + id + " deleted successfully.");
	}
	
	@GetMapping("/{categoryId}")
	public List<CourseDTO> getCoursesByCategoryId(@PathVariable long categoryId) {
		return courseService.getCourseByCategoryId(categoryId);
	}
}
