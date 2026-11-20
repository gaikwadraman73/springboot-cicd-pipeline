package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public static final String DEFAULT_GREETING = "Hello, Raman Gaikwad!";

    public String greet(String name) {
        if (name == null || name.isBlank()) {
            return DEFAULT_GREETING;
        }
        return "Hello, " + name.trim() + "!";
    }
}