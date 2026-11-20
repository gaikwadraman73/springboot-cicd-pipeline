package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

//http://localhost:9090/hello
//http://localhost:9090/hello?name=Pune	
//http://localhost:9090/version	
//http://localhost:9090/actuator/health	