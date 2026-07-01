package com.example.jobportal.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobportal.DTO.ApplicationDto;
import com.example.jobportal.Model.Application;
import com.example.jobportal.Services.ApplicationService;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    // Apply for Job
    @PostMapping("/apply")
    public ResponseEntity<String> applyJob(
            @RequestBody ApplicationDto dto,
            Authentication authentication) {

        return ResponseEntity.ok(
                applicationService.applyJob(dto, authentication.getName()));
    }

    // Get All Applications
    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications() {

        return ResponseEntity.ok(applicationService.getAllApplications());
    }

    // Get Application By ID
    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable Long id) {

        return ResponseEntity.ok(applicationService.getApplicationById(id));
    }

    // Delete Application
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApplication(@PathVariable Long id) {

        return ResponseEntity.ok(applicationService.deleteApplication(id));
    }
}