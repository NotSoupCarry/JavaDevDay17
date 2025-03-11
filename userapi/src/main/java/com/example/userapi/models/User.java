package com.example.userapi.models;

public class User {
    private Long id;
    private String name;
    private String email;

    public User(Long id, String name, String emai) {
        this.id = id;
        this.name = name;
        this.email = emai;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
