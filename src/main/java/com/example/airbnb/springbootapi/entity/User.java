package com.example.airbnb.springbootapi.entity;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Date dob;

    @Column(nullable = false)
    private String occupation;

    @Column(nullable = false)
    private int sin;

    //Getters
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Date getDob() {
        return dob;
    }

    public String getOccupation() {
        return occupation;
    }

    public Integer getSin() {
        return sin;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setSin(Integer sin) {
        this.sin = sin;
    }
}
