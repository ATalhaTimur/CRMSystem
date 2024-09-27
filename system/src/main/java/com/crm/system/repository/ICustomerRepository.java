package com.crm.system.repository;

import com.crm.system.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.firstName = :firstName AND c.lastName = :lastName")
    List<Customer> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("SELECT c FROM Customer c WHERE c.email = :email")
    Customer findByEmail(@Param("email") String email);

    @Query("SELECT c FROM Customer c WHERE c.registrationDate > :registrationDate")
    List<Customer> findByRegistrationDateAfter(@Param("registrationDate") LocalDate registrationDate);

    @Query("SELECT c FROM Customer c WHERE c.region = :region")
    List<Customer> findByRegion(@Param("region") String region);
}