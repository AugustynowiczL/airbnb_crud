package com.example.jira.springbootapi.controller;


import com.example.jira.springbootapi.entity.Availability;
import com.example.jira.springbootapi.entity.Listings;
import com.example.jira.springbootapi.service.AvailabilityService;
import com.example.jira.springbootapi.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1")
public class ListingController {

    private final ListingService listingService;
    private final AvailabilityService availabilityService;

    @Autowired
    public ListingController(ListingService listingService, AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
        this.listingService = listingService;
    }

    @PostMapping("/createListing")
    public ResponseEntity<Listings> createListing(@RequestBody Listings listing) {
        String contextUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!listing.getUid().equals(contextUsername)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(listing);
        }
        //Create listing
        Listings updatedListing = listingService.createListing(listing);
        // Create calender with availability
        LocalDate date = LocalDate.now();
        LocalDate endDate = date.plusYears(1);
        Availability availability = new Availability(listing.getId(), Date.valueOf(date), 0, listing.getPrice());
        availabilityService.createAvailability(availability);
        return ResponseEntity.ok(updatedListing);
    }
    @DeleteMapping("/deleteListing/{listingID}")
    public ResponseEntity<String> deleteListing(@PathVariable int listingID) {
        String contextUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        Listings listing = listingService.getListingById(listingID);
        if (listing.getUid().equals(contextUsername)){
            // delete all foreign key references {bookings, availabilities, listing amenities}
            // for now ,just delete the listing as booking is not yet implemented
            listingService.deleteById(listingID);
            return ResponseEntity.ok("Deleted listing " + listingID + " successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Cannot delete a listing you do not own");
        }
    }
}
