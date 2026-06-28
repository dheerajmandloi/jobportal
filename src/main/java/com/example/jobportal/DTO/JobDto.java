package com.example.jobportal.DTO;

import java.time.LocalDateTime;

public class JobDto {

    private Long jobId;
    private String jobTitle;
    private String companyName;
    private String location;
    private String jobType;
    private String experienceLevel;
    private Double salary;
    private String description;
    private String requirements;
    private String skills;
    private Boolean active;
    private LocalDateTime applicationDeadline;

    public JobDto() {
    }

    public JobDto(Long jobId, String jobTitle, String companyName,
            String location, String jobType,
            String experienceLevel, Double salary,
            String description, String requirements,
            String skills, Boolean active,
            LocalDateTime applicationDeadline) {

        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.location = location;
        this.jobType = jobType;
        this.experienceLevel = experienceLevel;
        this.salary = salary;
        this.description = description;
        this.requirements = requirements;
        this.skills = skills;
        this.active = active;
        this.applicationDeadline = applicationDeadline;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getApplicationDeadline() {
        return applicationDeadline;
    }

    public void setApplicationDeadline(LocalDateTime applicationDeadline) {
        this.applicationDeadline = applicationDeadline;
    }
}