package com.crm.system.repository;

import com.crm.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // İhtiyaca göre ek sorgular buraya eklenebilir
}
