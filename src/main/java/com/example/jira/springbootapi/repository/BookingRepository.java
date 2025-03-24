package com.example.jira.springbootapi.repository;

import com.example.jira.springbootapi.entity.Availability;
import com.example.jira.springbootapi.entity.Bookings;
import com.example.jira.springbootapi.entity.PaymentInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface BookingRepository extends JpaRepository<Bookings, Integer> {
}
