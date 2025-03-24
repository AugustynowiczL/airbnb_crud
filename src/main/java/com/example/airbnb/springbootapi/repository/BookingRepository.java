package com.example.airbnb.springbootapi.repository;

import com.example.airbnb.springbootapi.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Bookings, Integer> {
}
