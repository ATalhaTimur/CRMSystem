package com.crm.system.service;

import com.crm.system.entity.Customer;
import com.crm.system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    // Streams kullanarak bölgeye (region) göre filtreleme
    public List<Customer> getCustomersByRegion(String region) {
        return customerRepository.findAll().stream()
                .filter(customer -> customer.getRegion().equalsIgnoreCase(region))
                .collect(Collectors.toList());
    }

    // Streams kullanarak kayıt tarihine göre filtreleme (örneğin belirli bir tarihten sonra kayıt olan müşterileri filtreleme)
    public List<Customer> getCustomersRegisteredAfter(String date) {
        return customerRepository.findAll().stream()
                .filter(customer -> LocalDate.parse(customer.getRegistrationDate()).isAfter(LocalDate.parse(date)))
                .collect(Collectors.toList());
    }
}