package com.example.jira.springbootapi.service;

import com.example.jira.springbootapi.entity.User;
import com.example.jira.springbootapi.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Optional;

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
