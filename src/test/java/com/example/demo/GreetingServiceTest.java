package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingServiceTest {

    private final GreetingService service = new GreetingService();

    @Test
    void greetsByName() {
        assertEquals("Hello, Raman!", service.greet(" Raman "));
    }

    @Test
    void trimsName() {
        assertEquals("Hello, Ganesh!", service.greet("  Ganesh  "));
    }

    @Test
    void fallsBackToDefaultWhenBlank() {
        assertEquals("Hello, Raman Gaikwad!", service.greet(" "));
        assertEquals("Hello, Raman Gaikwad!", service.greet(null));
    }
}