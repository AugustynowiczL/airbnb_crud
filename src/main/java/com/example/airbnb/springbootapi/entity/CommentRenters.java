package com.example.airbnb.springbootapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CommentRenters")
public class CommentRenters {

    @Id
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private Bookings booking;

    @Id
    @Column(name = "comment")
    private String comment;

    // Getters and Setters
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Bookings getBooking() {
        return booking;
    }

    public void setBooking(Bookings booking) {
        this.booking = booking;
    }
}
