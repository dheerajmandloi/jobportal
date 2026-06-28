package com.example.jobportal.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jobportal.DTO.CompanyDto;
import com.example.jobportal.Model.Company;
import com.example.jobportal.Repository.CompanyRepository;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // Create Company
    public String createCompany(CompanyDto companyDto) {

        if (companyRepository.existsByCompanyEmail(companyDto.getCompanyEmail())) {
            throw new RuntimeException("Company email already exists.");
        }

        Company company = new Company();

        company.setCompanyName(companyDto.getCompanyName());
        company.setCompanyEmail(companyDto.getCompanyEmail());
        company.setCompanyPhone(companyDto.getCompanyPhone());
        company.setWebsite(companyDto.getWebsite());
        company.setIndustry(companyDto.getIndustry());
        company.setLocation(companyDto.getLocation());
        company.setDescription(companyDto.getDescription());
        company.setLogoUrl(companyDto.getLogoUrl());
        company.setActive(true);

        companyRepository.save(company);

        return "Company Created Successfully";
    }

    // Get All Companies
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    // Get Company By Id
    public Company getCompanyById(Long id) {

        return companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id : " + id));
    }

    // Update Company
    public String updateCompany(Long id, CompanyDto companyDto) {

        Company company = getCompanyById(id);

        company.setCompanyName(companyDto.getCompanyName());
        company.setCompanyEmail(companyDto.getCompanyEmail());
        company.setCompanyPhone(companyDto.getCompanyPhone());
        company.setWebsite(companyDto.getWebsite());
        company.setIndustry(companyDto.getIndustry());
        company.setLocation(companyDto.getLocation());
        company.setDescription(companyDto.getDescription());
        company.setLogoUrl(companyDto.getLogoUrl());
        company.setActive(companyDto.getActive());

        companyRepository.save(company);

        return "Company Updated Successfully";
    }

    // Delete Company
    public String deleteCompany(Long id) {

        Company company = getCompanyById(id);

        companyRepository.delete(company);

        return "Company Deleted Successfully";
    }
}