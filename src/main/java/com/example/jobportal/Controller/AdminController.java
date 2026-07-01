package com.example.jobportal.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobportal.Model.Application;
import com.example.jobportal.Model.Company;
import com.example.jobportal.Model.Job;
import com.example.jobportal.Model.User;
import com.example.jobportal.Services.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // ================= Dashboard =================

    @GetMapping("/dashboard")
    public ResponseEntity<Map<String, Long>> getDashboardStats() {

        Map<String, Long> dashboard = new HashMap<>();

        dashboard.put("totalUsers", adminService.getTotalUsers());
        dashboard.put("totalJobs", adminService.getTotalJobs());
        dashboard.put("totalCompanies", adminService.getTotalCompanies());
        dashboard.put("totalApplications", adminService.getTotalApplications());

        return ResponseEntity.ok(dashboard);
    }

    // ================= Users =================

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {

        adminService.deleteUser(id);

        return ResponseEntity.ok("User Deleted Successfully");
    }

    // ================= Jobs =================

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(adminService.getAllJobs());
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {

        adminService.deleteJob(id);

        return ResponseEntity.ok("Job Deleted Successfully");
    }

    // ================= Companies =================

    @GetMapping("/companies")
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(adminService.getAllCompanies());
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {

        adminService.deleteCompany(id);

        return ResponseEntity.ok("Company Deleted Successfully");
    }

    // ================= Applications =================

    @GetMapping("/applications")
    public ResponseEntity<List<Application>> getAllApplications() {
        return ResponseEntity.ok(adminService.getAllApplications());
    }

}