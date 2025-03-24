package com.example.airbnb.springbootapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.airbnb.springbootapi.entity.User;

@Repository
public interface AuthenticationRepository extends JpaRepository<User, String> {
}
