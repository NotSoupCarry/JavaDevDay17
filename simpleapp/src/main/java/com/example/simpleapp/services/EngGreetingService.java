package com.example.simpleapp.services;

import org.springframework.stereotype.Service;

@Service
public class EngGreetingService {
    public String getEngGreeting() {
        return "<div style='text-align: center; font-size: 20px; font-weight: bold; margin-top: 15px'>"
                + " <h1>Hello, welcome to your first Spring Boot app!</h1>" 
                + "<button style='background-color: blue; color: white; padding: 10px 20px; font-size: 16px; cursor: pointer; margin-top: 10px;' "
                + " onclick=\"window.location.href='/it/greet'\">italiano</button>"
                + "</div>";
    }
}
