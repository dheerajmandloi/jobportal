package com.example.jobportal.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobportal.DTO.JobDto;
import com.example.jobportal.Model.Job;
import com.example.jobportal.Services.JobService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // Create Job
    @PostMapping("/create")
    public ResponseEntity<String> createJob(@Valid @RequestBody JobDto jobDto) {
        return ResponseEntity.ok(jobService.createJob(jobDto));
    }

    // Get All Jobs
    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    // Get Job By Id
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        return ResponseEntity.ok(jobService.getJobById(id));
    }

    // Update Job
    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id,
            @Valid @RequestBody JobDto jobDto) {
        return ResponseEntity.ok(jobService.updateJob(id, jobDto));
    }

    // Delete Job
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        return ResponseEntity.ok(jobService.deleteJob(id));
    }
}