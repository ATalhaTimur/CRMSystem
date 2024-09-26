package com.crm.system.service;

import com.crm.system.entity.User;
import com.crm.system.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Save or update user
    public User saveUser(User user) {
        user.setUpdatedAt(LocalDateTime.now());
        if (user.getCreatedAt() == null) {
            user.setCreatedAt(LocalDateTime.now());
        }
        return userRepository.save(user);
    }

    // Delete user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Find users created after a specific date using JPA query
    public List<User> getUsersCreatedAfter(LocalDateTime date) {
        return userRepository.findByCreatedAtAfter(date);
    }

    // Find users by role using JPA query
    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }

    // Find user by username
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}