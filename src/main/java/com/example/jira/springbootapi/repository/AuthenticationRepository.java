package com.example.jira.springbootapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jira.springbootapi.entity.User;

@Repository
public interface AuthenticationRepository extends JpaRepository<User, String> {
}
