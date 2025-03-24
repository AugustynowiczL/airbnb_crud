package com.example.jira.springbootapi.controller;


import com.example.jira.springbootapi.entity.PaymentInformation;
import com.example.jira.springbootapi.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentInformation> savePayment(@RequestBody PaymentInformation paymentInformation) {
        System.out.println(paymentInformation.getId());
        System.out.println(paymentInformation.getCreditcard());
        String contextUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        if (paymentInformation.getId().equals(contextUsername)) {
            PaymentInformation paymentInfo = paymentService.savePayment(paymentInformation);
            return ResponseEntity.ok(paymentInfo);
        } else {
            System.out.println("Trying to create a new payment for another user");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(paymentInformation);
        }

    }
}
