package com.example.jira.springbootapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name="ListingAmenities")
public class ListingAmenities {

    @Id
    @ManyToOne
    @JoinColumn(name="lid", referencedColumnName = "id", nullable = false, updatable = false)
    private Listings listing;

    @Id
    @Column(nullable = false)
    private String name;

    public Listings getListing() {
        return listing;
    }

    public void setListing(Listings listing) {
        this.listing = listing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
