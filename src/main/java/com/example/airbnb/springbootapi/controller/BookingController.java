package com.example.airbnb.springbootapi.controller;


import com.example.airbnb.springbootapi.entity.Bookings;
import com.example.airbnb.springbootapi.entity.Listings;
import com.example.airbnb.springbootapi.service.AvailabilityService;
import com.example.airbnb.springbootapi.service.BookingService;
import com.example.airbnb.springbootapi.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/api/v1")
public class BookingController {

    private final BookingService bookingService;
    private final ListingService listingService;
    private final AvailabilityService availabilityService;

    @Autowired
    public BookingController(ListingService listingService, AvailabilityService availabilityService, BookingService bookingService) {
        this.availabilityService = availabilityService;
        this.listingService = listingService;
        this.bookingService = bookingService;
    }

    @PostMapping("/createBooking")
    public ResponseEntity<Bookings> createBooking(@RequestBody Bookings booking) {
        //Ensure user is booking for themselves

        String contextUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!booking.getUid().equals(contextUsername)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(booking);
        }

        // Ensure that the listing actually exists
        Listings listing = listingService.getListingById(booking.getLid());
        if (listing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(booking);
        }

        //Ensure that the booking is available for this start and end date
        long total_booking_days = ChronoUnit.DAYS.between(booking.getStart_date().toLocalDate(), booking.getEnd_date().toLocalDate()) + 1;
        int availabilities = availabilityService.available_dates(booking.getLid(), booking.getStart_date(), booking.getEnd_date()).size();

        if (availabilities != total_booking_days)
        {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(booking);
        }
        //Create booking
        Bookings createdBooking = bookingService.createBooking(booking);
        return ResponseEntity.ok(createdBooking);
    }
}
