package com.example.jira.springbootapi.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Bookings", uniqueConstraints = {
        @UniqueConstraint(name = "alternate_key", columnNames = {"lid", "start_date"})
})
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String uid;

    @Column(nullable = false)
    private int lid;

    @Column(nullable = false)
    private Date start_date;

    @Column(nullable = false)
    private Date end_date;

    // Getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public int getLid() {
        return lid;
    }
    public void setLid(int lid) {
        this.lid = lid;
    }
    public Date getStart_date() {
        return start_date;
    }
    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }
    public Date getEnd_date() {
        return end_date;
    }
    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
