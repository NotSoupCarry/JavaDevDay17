package com.example.userapi.services;

import com.example.userapi.models.User;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>(List.of(
            new User(1L, "Mario Rossi", "mario.rossi@example.com"),
            new User(2L, "Luca Bianchi", "luca.bianchi@example.com"),
            new User(3L, "Giulia Verdi", "giulia.verdi@example.com")));

    public List<User> getAllUsers() {
        return users;
    }

    public Optional<User> getUserById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public List<User> findUsersByName(String name) {
        return users.stream()
                .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    public User addUser(User user) {
        users.add(user); 
        return user; 
    }

    public void deleteUser(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }
    
}
