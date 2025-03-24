package com.example.jira.springbootapi.service;

import com.example.jira.springbootapi.entity.Listings;
import com.example.jira.springbootapi.repository.ListingRepository;
import com.example.jira.springbootapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
