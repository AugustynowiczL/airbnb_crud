package com.example.airbnb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@SpringBootApplication
public class JiraApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiraApplication.class, args);
    }

}
