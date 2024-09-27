package com.crm.system.repository;

import com.crm.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

    // Find by username using a custom SQL query
    @Query("SELECT u FROM User u WHERE u.username = :username")
    Optional<User> findByUsername(@Param("username") String username);

    // Find by role using a custom SQL query
    @Query("SELECT u FROM User u WHERE u.role = :role")
    List<User> findByRole(@Param("role") String role);

    // Find by region using a custom SQL query
    @Query("SELECT u FROM User u WHERE u.region = :region")
    List<User> findByRegion(@Param("region") String region);

    // Find users created after a specific date using a custom SQL query
    @Query("SELECT u FROM User u WHERE u.createdAt > :registrationDate")
    List<User> findByCreatedAtAfter(@Param("registrationDate") LocalDateTime registrationDate);
}