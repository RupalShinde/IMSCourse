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

import com.example.course.dto.NotificationDTO;
import com.example.course.model.Notification;
import com.example.course.service.NotificationsService;

@RestController
@RequestMapping("/Notifications")
public class NotificationsController {

	@Autowired
	private NotificationsService NotificationsService;
	
	@GetMapping
	public List<NotificationDTO> getNotifications() {
		return NotificationsService.getAllNotifications();
	}

	@PostMapping
	public ResponseEntity<Notification> createOrUpdateNotifications(@RequestBody NotificationDTO Notifications) {
		Notification savedNotifications = NotificationsService.createOrUpdateNotifications(Notifications);
		return ResponseEntity.ok(savedNotifications);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Notification> updateNotifications(@PathVariable long id, @RequestBody NotificationDTO NotificationsDTO) {
		NotificationsDTO.setId(id); 
		Notification updatedUser = NotificationsService.createOrUpdateNotifications(NotificationsDTO); 
	    return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteNotifications(@PathVariable int id) {
		NotificationsService.deleteNotificationsById(id);
	    return ResponseEntity.ok("Notifications with ID " + id + " deleted successfully.");
	}
	
	@GetMapping("/{userId}")
	public List<NotificationDTO> getNotificationsByUserId(@PathVariable long userId) {
		return NotificationsService.getNotificationsByUserId(userId);
	}
}
