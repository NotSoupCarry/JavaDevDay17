package com.example.simpleapp.controllers;

import com.example.simpleapp.services.ItaGreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/it")
public class ItaGreetingController {
    private final ItaGreetingService greetingService;

    public ItaGreetingController(ItaGreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greet")
    public String greetIta() {
        return greetingService.getItaGreeting();
    }
}