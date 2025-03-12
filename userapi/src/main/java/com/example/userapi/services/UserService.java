package com.example.userapi.services;

import com.example.userapi.models.User;
import com.example.userapi.repository.UserRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        // return users;
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        // return users.stream().filter(user -> user.getId().equals(id)).findFirst();
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));
    }

    public List<User> findUsersByName(String name) {
        // return users.stream()
        // .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
        // .toList();ù
        return null;
    }

    @Transactional
    public User addUser(User newUser) {
        // users.add(newUser);
        // return newUser;
        return userRepository.save(newUser);
    }

    public void deleteUser(Long id) {
        // users.removeIf(user -> user.getId().equals(id));
        userRepository.deleteById(id);
    }

}
