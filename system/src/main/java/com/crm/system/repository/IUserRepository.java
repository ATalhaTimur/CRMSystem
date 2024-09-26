package com.crm.system.repository;

import com.crm.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

    // Method to find by username (return Optional for better error handling)
    Optional<User> findByUsername(String username);

    // Method to find users by role
    List<User> findByRole(String role);

    // Find users created after a specific date
    List<User> findByCreatedAtAfter(LocalDateTime date);
}