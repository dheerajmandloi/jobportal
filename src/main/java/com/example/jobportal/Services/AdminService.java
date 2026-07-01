package com.example.jobportal.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jobportal.Model.Application;
import com.example.jobportal.Model.Company;
import com.example.jobportal.Model.Job;
import com.example.jobportal.Model.User;
import com.example.jobportal.Repository.ApplicationRepository;
import com.example.jobportal.Repository.CompanyRepository;
import com.example.jobportal.Repository.JobRepository;
import com.example.jobportal.Repository.UserRepository;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;
    private final ApplicationRepository applicationRepository;

    public AdminService(UserRepository userRepository,
            JobRepository jobRepository,
            CompanyRepository companyRepository,
            ApplicationRepository applicationRepository) {

        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
        this.applicationRepository = applicationRepository;
    }

    // ================= Dashboard =================

    public long getTotalUsers() {
        return userRepository.count();
    }

    public long getTotalJobs() {
        return jobRepository.count();
    }

    public long getTotalCompanies() {
        return companyRepository.count();
    }

    public long getTotalApplications() {
        return applicationRepository.count();
    }

    // ================= Users =================

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // ================= Jobs =================

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    // ================= Companies =================

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    // ================= Applications =================

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }
}