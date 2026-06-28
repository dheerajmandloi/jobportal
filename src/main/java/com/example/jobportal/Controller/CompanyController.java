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

import com.example.jobportal.DTO.CompanyDto;
import com.example.jobportal.Model.Company;
import com.example.jobportal.Services.CompanyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    // Create Company
    @PostMapping("/create")
    public ResponseEntity<String> createCompany(@Valid @RequestBody CompanyDto companyDto) {
        return ResponseEntity.ok(companyService.createCompany(companyDto));
    }

    // Get All Companies
    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    // Get Company By ID
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.getCompanyById(id));
    }

    // Update Company
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,
            @Valid @RequestBody CompanyDto companyDto) {
        return ResponseEntity.ok(companyService.updateCompany(id, companyDto));
    }

    // Delete Company
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.deleteCompany(id));
    }
}