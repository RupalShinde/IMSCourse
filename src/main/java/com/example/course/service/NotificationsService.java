package com.example.course.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.dto.NotificationDTO;
import com.example.course.model.Notification;
import com.example.course.repository.NotificationsRepository;

@Service
public class NotificationsService {
		
	@Autowired
    private NotificationsRepository notificationsRepository;
	
	private final ModelMapper modelMapper = new ModelMapper();
	
    public NotificationDTO convertToDTO(Notification Notifications) {
        return modelMapper.map(Notifications, NotificationDTO.class);
    }
    
    public Notification convertToEntity(NotificationDTO NotificationsDTO) {
        return modelMapper.map(NotificationsDTO, Notification.class);
    }


    public Notification createOrUpdateNotifications(NotificationDTO NotificationsDTO) {
    	return notificationsRepository.save(convertToEntity(NotificationsDTO)); 
    }
    
    public List<NotificationDTO> getAllNotifications() {
    	List<Notification> categories = notificationsRepository.findAll(); // Fetch all users
        return categories.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public void deleteNotificationsById(int id) {
    	notificationsRepository.deleteById(id);
    }
    
    public List<NotificationDTO> getNotificationsByUserId(long userId) {
    	List<Notification> notifications = notificationsRepository.findAllByUserId(userId);
        return notifications.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

	
}
