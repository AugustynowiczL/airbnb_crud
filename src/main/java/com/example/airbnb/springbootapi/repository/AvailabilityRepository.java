package com.example.airbnb.springbootapi.repository;

import com.example.airbnb.springbootapi.entity.Availability;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface AvailabilityRepository extends JpaRepository<Availability, Integer> {
    @Query("SELECT a FROM Availability a WHERE a.id = :lid AND a.isAvailable = 0 AND a.date BETWEEN :start_date AND :end_date")
    List<Availability> findUnavailabilities(@Param("lid") int listingId,
                                            @Param("start_date") Date startDate,
                                            @Param("end_date") Date endDate);
    @Modifying
    @Transactional
    @Query("UPDATE Availability a SET a.isAvailable = 1 WHERE a.id = :lid AND a.date BETWEEN :start_date AND :end_date")
    void updateAvailability(@Param("lid") int listingId,
                            @Param("start_date") Date startDate,
                            @Param("end_date") Date endDate);
}
