package com.example.simpleapp.services;

import org.springframework.stereotype.Service;

@Service
public class ItaGreetingService {
    public String getItaGreeting() {
        return "<div style='text-align: center; font-size: 20px; font-weight: bold; margin-top: 15px'>"
                + " <h1>Ciao, benvenuto nella tua prima app Spring Boot!!</h1>"
                + "<button style='background-color: blue; color: white; padding: 10px 20px; font-size: 16px; margin-top: 10px;' "
                + " onclick=\"window.location.href='/eng/greet'\">english</button>"
                + "</div>";
    }
}
