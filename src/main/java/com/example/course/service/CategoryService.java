package com.example.course.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.dto.CategoryDTO;
import com.example.course.model.Category;
import com.example.course.repository.CategoryRepository;

@Service
public class CategoryService {
		
	@Autowired
    private CategoryRepository categoryRepository;
	
	private final ModelMapper modelMapper = new ModelMapper();
	
    public CategoryDTO convertToDTO(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }
    
    public Category convertToEntity(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, Category.class);
    }


    public Category createOrUpdateCategory(CategoryDTO categoryDTO) {
    	return categoryRepository.save(convertToEntity(categoryDTO)); 
    }
    
    public List<CategoryDTO> getAllCategories() {
    	List<Category> categories = categoryRepository.findAll(); // Fetch all users
        return categories.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public void deleteCategoryById(long id) {
        categoryRepository.deleteById(id);
    }

    public CategoryDTO getCategoryById(long id){
    	Category category=null;
    	Optional<Category> categoryOptional=categoryRepository.findById(id);
    	if(categoryOptional.isPresent()) {
    		category = categoryOptional.get();
    	}
    	return convertToDTO(category);
    }
	
}
