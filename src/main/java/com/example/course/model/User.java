package com.example.course.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userType;
    private String name;
    private String phoneNumber;
    private String email;
    private String state;

    private LocalDateTime lastLoggedOn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Relationships
    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Notification> notifications;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<CourseSubscription> subscriptions;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<CustomerServiceChat> chats;
}


