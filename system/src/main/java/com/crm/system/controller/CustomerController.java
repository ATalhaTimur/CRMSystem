package com.crm.system.controller;

import com.crm.system.entity.Customer;
import com.crm.system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/region/{region}")
    public List<Customer> getCustomersByRegion(@PathVariable String region) {
        return customerService.getCustomersByRegion(region);
    }

    @GetMapping("/registered-after/{date}")
    public List<Customer> getCustomersRegisteredAfter(@PathVariable String date) {
        return customerService.getCustomersRegisteredAfter(date);
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}