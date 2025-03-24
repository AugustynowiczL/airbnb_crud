package com.example.jira.springbootapi.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@IdClass(PaymentInformation.class)
@Table(name = "PaymentInformation")
public class PaymentInformation implements Serializable {

    @Id
    @Column(nullable = false)
    private String id;

    @Id
    @Column(nullable = false)
    private int creditcard;

    //Getters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(int creditCard) {
        this.creditcard = creditCard;
    }
}
