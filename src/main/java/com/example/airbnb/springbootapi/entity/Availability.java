package com.example.airbnb.springbootapi.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@IdClass(Availability.class)
@Table(name = "Availability")
public class Availability implements Serializable {

    @Id
    @Column(nullable = false)
    private int id;

    @Id
    @Column(nullable = false)
    private java.sql.Date date;

    @Column(nullable = false)
    private int isAvailable;

    @Column(nullable = false)
    private float price;

    public Availability() {}

    public Availability(int id, Date date, int type, float price) {
        setId(id);
        setDate(date);
        setIsAvailable(type);
        setPrice(price);
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }


    public int getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(int isAvailable) {
        this.isAvailable = isAvailable;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
