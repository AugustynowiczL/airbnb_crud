package com.example.jira.springbootapi.repository;

import com.example.jira.springbootapi.entity.PaymentInformation;
import com.example.jira.springbootapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentInformation, String> {
}
