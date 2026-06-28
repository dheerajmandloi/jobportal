package com.example.jobportal.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jobportal.DTO.JobDto;
import com.example.jobportal.Model.Job;
import com.example.jobportal.Repository.JobRepository;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // Create Job
    public String createJob(JobDto jobDto) {

        Job job = new Job();

        job.setJobTitle(jobDto.getJobTitle());
        job.setCompanyName(jobDto.getCompanyName());
        job.setLocation(jobDto.getLocation());
        job.setJobType(jobDto.getJobType());
        job.setExperienceLevel(jobDto.getExperienceLevel());
        job.setSalary(jobDto.getSalary());
        job.setDescription(jobDto.getDescription());
        job.setRequirements(jobDto.getRequirements());
        job.setSkills(jobDto.getSkills());
        job.setApplicationDeadline(jobDto.getApplicationDeadline());

        job.setActive(true);

        jobRepository.save(job);

        return "Job Created Successfully";
    }

    // Get All Jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // Get Job By ID
    public Job getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id : " + id));
    }

    // Update Job
    public String updateJob(Long id, JobDto jobDto) {

        Job job = getJobById(id);

        job.setJobTitle(jobDto.getJobTitle());
        job.setCompanyName(jobDto.getCompanyName());
        job.setLocation(jobDto.getLocation());
        job.setJobType(jobDto.getJobType());
        job.setExperienceLevel(jobDto.getExperienceLevel());
        job.setSalary(jobDto.getSalary());
        job.setDescription(jobDto.getDescription());
        job.setRequirements(jobDto.getRequirements());
        job.setSkills(jobDto.getSkills());
        job.setApplicationDeadline(jobDto.getApplicationDeadline());

        jobRepository.save(job);

        return "Job Updated Successfully";
    }

    // Delete Job
    public String deleteJob(Long id) {

        Job job = getJobById(id);

        jobRepository.delete(job);

        return "Job Deleted Successfully";
    }
}