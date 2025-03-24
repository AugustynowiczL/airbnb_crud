package com.example.airbnb.springbootapi.service;

import com.example.airbnb.springbootapi.entity.Listings;
import com.example.airbnb.springbootapi.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListingService {

    private final ListingRepository listingRepository;

    @Autowired
    public ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    public Listings createListing(Listings listing) {
        return listingRepository.save(listing);
    }

    public Listings getListingById(int listingID) {
        return listingRepository.findById(listingID).orElse(null);
    }

    public void deleteById(int listingID) {
        listingRepository.deleteById(listingID);
    }

}
