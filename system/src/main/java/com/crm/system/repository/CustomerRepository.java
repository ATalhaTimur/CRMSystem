package com.crm.system.repository;

import com.crm.system.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // İhtiyaca göre ek sorgular buraya eklenebilir
}