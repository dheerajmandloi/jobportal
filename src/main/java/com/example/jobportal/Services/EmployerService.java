package com.example.jobportal.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jobportal.Model.Application;
import com.example.jobportal.Model.Company;
import com.example.jobportal.Model.Job;
import com.example.jobportal.Repository.ApplicationRepository;
import com.example.jobportal.Repository.CompanyRepository;
import com.example.jobportal.Repository.JobRepository;

@Service
public class EmployerService {

    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;
    private final ApplicationRepository applicationRepository;

    public EmployerService(JobRepository jobRepository,
            CompanyRepository companyRepository,
            ApplicationRepository applicationRepository) {

        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
        this.applicationRepository = applicationRepository;
    }

    // ================= Dashboard =================

    public long getTotalJobs() {
        return jobRepository.count();
    }

    public long getTotalCompanies() {
        return companyRepository.count();
    }

    public long getTotalApplications() {
        return applicationRepository.count();
    }

    // ================= Jobs =================

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    // ================= Companies =================

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));
    }

    // ================= Applications =================

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }
}