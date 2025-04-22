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

import com.example.course.dto.CategoryDTO;
import com.example.course.model.Category;
import com.example.course.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public List<CategoryDTO> getCategory() {
		return categoryService.getAllCategories();
	}
	
	@GetMapping("/{id}")
	public CategoryDTO getCategoryById(@PathVariable long id) {
		return categoryService.getCategoryById(id);
	}

	@PostMapping
	public ResponseEntity<Category> createCategory(@RequestBody CategoryDTO category) {
		Category savedCategory = categoryService.createOrUpdateCategory(category);
		return ResponseEntity.ok(savedCategory);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable long id, @RequestBody CategoryDTO categoryDTO) {
		categoryDTO.setId(id); 
		Category updatedUser = categoryService.createOrUpdateCategory(categoryDTO); 
	    return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable long id) {
		categoryService.deleteCategoryById(id);
	    return ResponseEntity.ok("Category with ID " + id + " deleted successfully.");
	}
}
