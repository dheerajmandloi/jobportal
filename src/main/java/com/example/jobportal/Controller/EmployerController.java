package com.example.jobportal.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobportal.Model.Application;
import com.example.jobportal.Model.Company;
import com.example.jobportal.Model.Job;
import com.example.jobportal.Services.EmployerService;

@RestController
@RequestMapping("/api/employer")
public class EmployerController {

    private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    // ================= Dashboard =================

    @GetMapping("/dashboard")
    public ResponseEntity<Long[]> getDashboard() {

        Long[] stats = {
                employerService.getTotalJobs(),
                employerService.getTotalCompanies(),
                employerService.getTotalApplications()
        };

        return ResponseEntity.ok(stats);
    }

    // ================= Jobs =================

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(employerService.getAllJobs());
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        return ResponseEntity.ok(employerService.getJobById(id));
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {

        employerService.deleteJob(id);

        return ResponseEntity.ok("Job Deleted Successfully");
    }

    // ================= Companies =================

    @GetMapping("/companies")
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(employerService.getAllCompanies());
    }

    @GetMapping("/companies/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        return ResponseEntity.ok(employerService.getCompanyById(id));
    }

    // ================= Applications =================

    @GetMapping("/applications")
    public ResponseEntity<List<Application>> getAllApplications() {
        return ResponseEntity.ok(employerService.getAllApplications());
    }

}