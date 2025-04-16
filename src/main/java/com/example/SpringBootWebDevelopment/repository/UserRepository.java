package com.example.SpringBootWebDevelopment.repository;
import org.springframework.data.domain.Pageable;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootWebDevelopment.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

	Page<User> findAll(Pageable pageable);
}
