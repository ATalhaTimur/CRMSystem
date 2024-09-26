package com.crm.system.service;

import com.crm.system.entity.Customer;
import com.crm.system.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get customer by ID
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Save or update customer
    public Customer saveCustomer(Customer customer) {
        customer.setUpdatedAt(LocalDate.now()); // Updated to LocalDate
        if (customer.getRegistrationDate() == null) {
            customer.setRegistrationDate(LocalDate.now()); // Updated to LocalDate
        }
        return customerRepository.save(customer);
    }

    // Delete customer by ID
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    // Stream-based filtering to get customers created after a specific date
    public List<Customer> getCustomersCreatedAfter(LocalDate registrationDate) {
        return customerRepository.findAll()
                .stream()
                .filter(customer -> customer.getRegistrationDate().isAfter(registrationDate))
                .collect(Collectors.toList());
    }

    // Stream-based filtering to get customers by region
    public List<Customer> getCustomersByRegion(String region) {
        return customerRepository.findAll()
                .stream()
                .filter(customer -> region.equals(customer.getRegion()))
                .collect(Collectors.toList());
    }

    // Find customers by first and last name
    public List<Customer> getCustomersByName(String firstName, String lastName) {
        return customerRepository.findAll()
                .stream()
                .filter(customer -> customer.getFirstName().equals(firstName) && customer.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    // Find customer by email
    public Optional<Customer> getCustomerByEmail(String email) {
        return customerRepository.findAll()
                .stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findFirst();
    }
}