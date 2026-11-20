package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    private final GreetingService greetingService;
    private final String version;

    public HelloController(GreetingService greetingService,
                           @Value("${app.version:dev}") String version) {
        this.greetingService = greetingService;
        this.version = version;
    }

    @GetMapping("/hello")
    public Map<String, String> hello(@RequestParam(required = false) String name) {
        return Map.of("message", greetingService.greet(name));
    }

    @GetMapping("/version")
    public Map<String, String> version() {
        return Map.of("version", version);
    }
}