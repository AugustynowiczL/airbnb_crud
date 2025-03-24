package com.example.airbnb.springbootapi.repository;

import com.example.airbnb.springbootapi.entity.Listings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepository extends JpaRepository<Listings, Integer> {
}
