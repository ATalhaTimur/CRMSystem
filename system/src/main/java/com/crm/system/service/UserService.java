package com.crm.system.service;

import com.crm.system.entity.User;
import com.crm.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Streams kullanarak rol bazlı kullanıcıları filtreleme
    public List<User> getUsersByRole(String role) {
        return userRepository.findAll().stream()
                .filter(user -> user.getRole().equalsIgnoreCase(role))
                .collect(Collectors.toList());
    }

    // Streams kullanarak kullanıcıları oluşturulma tarihine göre filtreleme
    public List<User> getUsersCreatedAfter(String date) {
        return userRepository.findAll().stream()
                .filter(user -> user.getCreatedAt().isAfter(LocalDateTime.parse(date)))
                .collect(Collectors.toList());
    }
}