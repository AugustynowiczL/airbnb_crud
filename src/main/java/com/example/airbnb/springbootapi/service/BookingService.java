package com.example.airbnb.springbootapi.service;

import com.example.airbnb.springbootapi.entity.Bookings;
import com.example.airbnb.springbootapi.repository.AvailabilityRepository;
import com.example.airbnb.springbootapi.repository.BookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final AvailabilityRepository availabilityRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, AvailabilityRepository availabilityRepository) {
        this.bookingRepository = bookingRepository;
        this.availabilityRepository = availabilityRepository;
    }

    // Has to be done atomically in case on of the insert or updates fails
    @Transactional
    public Bookings createBooking(Bookings booking) {
        //insert booking record
        Bookings createdBooking =  bookingRepository.save(booking);

        //update availability table
        availabilityRepository.updateAvailability(booking.getLid(), booking.getStart_date(), booking.getEnd_date());

        return createdBooking;
    }

    public Bookings getBookingById(int bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }

    public void deleteById(int listingID) {
        bookingRepository.deleteById(listingID);
    }

}
