package com.example.airbnb.springbootapi.service;

import com.example.airbnb.springbootapi.entity.User;
import com.example.airbnb.springbootapi.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

@Service
public class AuthenticationService {

    private final AuthenticationRepository authenticationRepository;

    @Autowired
    public AuthenticationService(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    public boolean authenticate(Authentication id) {
        String username = id.getName();
        String password = id.getCredentials().toString();
        User user = authenticationRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        // return true if password matches
        return password.equals(user.getPassword());
    }

}
