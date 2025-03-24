package com.example.airbnb.springbootapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name="RatingHosts")
public class RatingHosts {

    @Id
    @ManyToOne
    @JoinColumn(name="id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    private Bookings booking;

    @Column(nullable = false)
    private int rating;

    // Getters
    public Bookings getBooking() {
        return booking;
    }
    public void setBooking(Bookings booking) {
        this.booking = booking;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
}
