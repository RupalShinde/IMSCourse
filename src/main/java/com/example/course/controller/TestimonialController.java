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

import com.example.course.dto.TestimonialDTO;
import com.example.course.model.Testimonial;
import com.example.course.service.TestimonialService;

@RestController
@RequestMapping("/Testimonial")
public class TestimonialController {

	@Autowired
	private TestimonialService testimonialService;
	
	@GetMapping
	public List<TestimonialDTO> getTestimonial() {
		return testimonialService.getAllTestimonials();
	}

	@PostMapping
	public ResponseEntity<Testimonial> createOrUpdateCategory(@RequestBody TestimonialDTO TestimonialDTO) {
		Testimonial savedTestimonial = testimonialService.createOrUpdateTestimonials(TestimonialDTO);
		return ResponseEntity.ok(savedTestimonial);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Testimonial> updateTestimonials(@PathVariable long id, @RequestBody TestimonialDTO TestimonialDTO) {
		TestimonialDTO.setId(id); 
		Testimonial updatedTestimonial = testimonialService.createOrUpdateTestimonials(TestimonialDTO); 
	    return ResponseEntity.ok(updatedTestimonial);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTestimonial(@PathVariable long id) {
		testimonialService.deleteTestimonialsById(id);
	    return ResponseEntity.ok("Testimonial with ID " + id + " deleted successfully.");
	}
}
