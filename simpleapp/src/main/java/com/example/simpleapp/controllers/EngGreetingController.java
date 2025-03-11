package com.example.simpleapp.controllers;

import com.example.simpleapp.services.EngGreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eng")
public class EngGreetingController {
    private final EngGreetingService greetingService;

    public EngGreetingController(EngGreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greet")
    public String greetEng() {
        return greetingService.getEngGreeting();
    }   
}