package com.example.airbnb.springbootapi.service;

import com.example.airbnb.springbootapi.entity.PaymentInformation;
import com.example.airbnb.springbootapi.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public PaymentInformation savePayment(PaymentInformation paymentInformation) {
        return paymentRepository.save(paymentInformation);
    }
}
