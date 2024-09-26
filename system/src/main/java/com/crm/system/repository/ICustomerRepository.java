package com.crm.system.repository;

import com.crm.system.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    // Custom query to find customers by their first and last name
    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

    // Find customers by email
    Customer findByEmail(String email);

    // Find customers created after a specific date (stream-based filtering)
    List<Customer> findByRegistrationDateAfter(LocalDate registrationDate);

    // Find customers by region
    List<Customer> findByRegion(String region);
}