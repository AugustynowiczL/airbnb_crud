package com.example.jira.springbootapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name="RenterCancellations")
public class RenterCancellations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String username;

    // Getters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
