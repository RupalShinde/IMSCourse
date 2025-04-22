package com.example.course.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.dto.TestimonialDTO;
import com.example.course.model.Testimonial;
import com.example.course.repository.TestimonialRepository;

@Service
public class TestimonialService {

    @Autowired
    private TestimonialRepository testimonialsRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public TestimonialDTO convertToDTO(Testimonial testimonials) {
        return modelMapper.map(testimonials, TestimonialDTO.class);
    }

    public Testimonial convertToEntity(TestimonialDTO testimonialsDTO) {
        return modelMapper.map(testimonialsDTO, Testimonial.class);
    }

    public Testimonial createOrUpdateTestimonials(TestimonialDTO testimonialsDTO) {
        return testimonialsRepository.save(convertToEntity(testimonialsDTO));
    }

    public List<TestimonialDTO> getAllTestimonials() {
        List<Testimonial> testimonials = testimonialsRepository.findAll();
        return testimonials.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void deleteTestimonialsById(long id) {
        testimonialsRepository.deleteById(id);
    }
}
