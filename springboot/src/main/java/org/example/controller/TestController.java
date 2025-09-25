package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, MyMusic Spring Boot Application is running!";
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to MyMusic API! Ready for your implementation.";
    }
}
