package com.example.jira.springbootapi.service;

import com.example.jira.springbootapi.entity.Availability;
import com.example.jira.springbootapi.repository.AvailabilityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AvailabilityService {

    private final AvailabilityRepository availabilityRepository;
    private static final int BATCH_SIZE = 50;
    @Autowired
    public AvailabilityService(AvailabilityRepository availabilityRepository) {
        this.availabilityRepository = availabilityRepository;
    }

    @Transactional
    public Availability createAvailability(Availability availability) {
        LocalDate date = availability.getDate().toLocalDate();
        LocalDate endDate = date.plusYears(1);

        List<Availability> availabilityBatch = new ArrayList<>();

        while (!date.isAfter(endDate)) {
            Availability newAvailability = new Availability(availability.getId(), Date.valueOf(date), 0, availability.getPrice());
            availabilityBatch.add(newAvailability);
            System.out.println(newAvailability.getIsAvailable());

            // If the batch size is reached, save and clear the batch
            if (availabilityBatch.size() >= BATCH_SIZE) {
                availabilityRepository.saveAll(availabilityBatch);  // Save the batch
                availabilityBatch.clear();  // Clear the batch
            }

            // Move to the next day
            date = date.plusDays(1);
        }

        // Save any remaining records in the batch
        if (!availabilityBatch.isEmpty()) {
            availabilityRepository.saveAll(availabilityBatch);
        }

        return availability;
    }

    @Transactional
    public List<Availability> available_dates(int lid, Date start_date, Date end_date) {
        return availabilityRepository.findUnavailabilities(lid, start_date, end_date);
    }
}
