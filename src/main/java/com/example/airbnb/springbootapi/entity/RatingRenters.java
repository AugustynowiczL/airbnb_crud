package com.example.airbnb.springbootapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name="RatingRenters")
public class RatingRenters {

    @Id
    @ManyToOne
    @JoinColumn(name="id", referencedColumnName = "id", insertable = false, updatable = false)
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
