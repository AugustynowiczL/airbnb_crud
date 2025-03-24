package com.example.jira.springbootapi.entity;

import jakarta.persistence.*;

import java.awt.print.Book;

@Entity
@Table(name="CommentHosts")
public class CommentHosts {

    @Id
    @ManyToOne
    @JoinColumn(name="id", referencedColumnName = "id", nullable = false, updatable = false)
    private Bookings booking;

    @Id
    @Column(nullable = false)
    private String comment;

    // Getters
    public Bookings getBooking() {
        return booking;
    }
    public void setBooking(Bookings booking) {
        this.booking = booking;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
}
