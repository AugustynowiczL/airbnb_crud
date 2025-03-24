package com.example.airbnb.springbootapi.controller;

import com.example.airbnb.springbootapi.entity.User;
import com.example.airbnb.springbootapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        System.out.println("Trying to create user");
        User newUser = userService.saveUser(user);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        System.out.println("Call to get all users");
        return userService.getAllUsers();
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        Optional<User> user = userService.getUserById(username);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        String contextUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        if (contextUsername.equals(user.getId())) {
            //ensure user only changes his own profile
            User updatedUser = userService.updateUser(user.getId(), user);
            return ResponseEntity.ok(updatedUser);
        } else
        {
            System.out.println("Username not matched");
            return ResponseEntity.status(403).build();
        }
    }
}
