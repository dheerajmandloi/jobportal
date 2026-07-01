package com.example.jobportal.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jobportal.DTO.ApplicationDto;
import com.example.jobportal.Model.Application;
import com.example.jobportal.Model.Job;
import com.example.jobportal.Model.User;
import com.example.jobportal.Repository.ApplicationRepository;
import com.example.jobportal.Repository.JobRepository;
import com.example.jobportal.Repository.UserRepository;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;

    public ApplicationService(ApplicationRepository applicationRepository,
            UserRepository userRepository,
            JobRepository jobRepository) {

        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
    }

    // Apply for Job
    public String applyJob(ApplicationDto dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Job job = jobRepository.findById(dto.getJobId())
                .orElseThrow(() -> new RuntimeException("Job not found"));

        Application application = new Application();

        application.setUser(user);
        application.setJob(job);
        application.setStatus("Applied");

        applicationRepository.save(application);

        return "Application Submitted Successfully";
    }

    // Get All Applications
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    // Get Application By Id
    public Application getApplicationById(Long id) {

        return applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));
    }

    // Delete Application
    public String deleteApplication(Long id) {

        applicationRepository.deleteById(id);

        return "Application Deleted Successfully";
    }

}