package com.example.jobportal.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobportal.Model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    // Company name se search
    List<Company> findByCompanyNameContainingIgnoreCase(String companyName);

    // Company email se fetch
    Optional<Company> findByCompanyEmail(String companyEmail);

    // Email already exist check
    boolean existsByCompanyEmail(String companyEmail);

    // Active companies
    List<Company> findByActiveTrue();
}