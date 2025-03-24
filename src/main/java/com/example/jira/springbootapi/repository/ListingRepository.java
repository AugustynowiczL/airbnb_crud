package com.example.jira.springbootapi.repository;

import com.example.jira.springbootapi.entity.Listings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jira.springbootapi.entity.User;

@Repository
public interface ListingRepository extends JpaRepository<Listings, Integer> {
}
