package com.example.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
