package com.example.jobportal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobportal.Model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    // Active jobs fetch karne ke liye
    List<Job> findByActiveTrue();

    // Company ke naam se jobs
    List<Job> findByCompanyName(String companyName);

    // Job title search
    List<Job> findByJobTitleContainingIgnoreCase(String jobTitle);

    // Location search
    List<Job> findByLocationContainingIgnoreCase(String location);
}