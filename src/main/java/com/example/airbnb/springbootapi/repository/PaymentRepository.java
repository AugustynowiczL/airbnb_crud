package com.example.airbnb.springbootapi.repository;

import com.example.airbnb.springbootapi.entity.PaymentInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentInformation, String> {
}
