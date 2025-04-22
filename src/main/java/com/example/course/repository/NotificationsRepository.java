package com.example.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.model.Notification;

public interface NotificationsRepository extends JpaRepository<Notification, Integer> {
	
	public List<Notification> findAllByUserId(long userId);

}
