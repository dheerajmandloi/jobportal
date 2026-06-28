package com.example.jobportal.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobportal.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Login aur authentication ke waqt email se user fetch karne ke liye
    Optional<User> findByEmail(String email);
    
    // Check karne ke liye ki registration ke waqt email already exist toh nahi karta
    Boolean existsByEmail(String email);
}