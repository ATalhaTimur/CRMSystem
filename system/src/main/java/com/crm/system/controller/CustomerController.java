package com.crm.system.controller;

import com.crm.system.entity.Customer;
import com.crm.system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Get all customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Get customer by ID
    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    // Create or update a customer
    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    // Delete customer by ID
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    // Get customers created after a certain date
    @GetMapping("/created-after/{date}")
    public List<Customer> getCustomersCreatedAfter(@PathVariable String date) {
        LocalDate createdAfterDate = LocalDate.parse(date);
        return customerService.getCustomersCreatedAfter(createdAfterDate);
    }

    // Get customers by region
    @GetMapping("/region/{region}")
    public List<Customer> getCustomersByRegion(@PathVariable String region) {
        return customerService.getCustomersByRegion(region);
    }

    // Get customers by first and last name
    @GetMapping("/name")
    public List<Customer> getCustomersByName(@RequestParam String firstName, @RequestParam String lastName) {
        return customerService.getCustomersByName(firstName, lastName);
    }

    // Get customer by email
    @GetMapping("/email/{email}")
    public Optional<Customer> getCustomerByEmail(@PathVariable String email) {
        return customerService.getCustomerByEmail(email);
    }
}