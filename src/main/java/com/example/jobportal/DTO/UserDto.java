package com.example.jobportal.DTO;

import com.example.jobportal.Model.ExperienceType;
import com.example.jobportal.Model.Role;

public class UserDto {

    private Long userId;
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;

    private String profileImage;
    private String resumeUrl;

    private String githubUrl;
    private String linkedinUrl;
    private String portfolioUrl;

    private String qualification;
    private String collegeName;
    private Double cgpa;
    private Integer graduationYear;

    private String skills;

    private String currentCity;

    private ExperienceType experienceType;
    private Integer experienceYears;

    private String currentCompany;
    private String currentDesignation;

    private Double currentSalary;
    private Double expectedSalary;

    private String noticePeriod;

    private Integer profileCompletion;

    private Role role;

    public UserDto() {
    }

    public UserDto(Long userId, String fullName, String email, String password,
            String phoneNumber, String profileImage, String resumeUrl,
            String githubUrl, String linkedinUrl, String portfolioUrl,
            String qualification, String collegeName, Double cgpa,
            Integer graduationYear, String skills, String currentCity,
            ExperienceType experienceType, Integer experienceYears,
            String currentCompany, String currentDesignation,
            Double curreentSalery, Double expectedSalary,
            String noticePeriod, Integer profileCompletion,
            Role role) {

        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;

        this.profileImage = profileImage;
        this.resumeUrl = resumeUrl;

        this.githubUrl = githubUrl;
        this.linkedinUrl = linkedinUrl;
        this.portfolioUrl = portfolioUrl;

        this.qualification = qualification;
        this.collegeName = collegeName;
        this.cgpa = cgpa;
        this.graduationYear = graduationYear;

        this.skills = skills;
        this.currentCity = currentCity;

        this.experienceType = experienceType;
        this.experienceYears = experienceYears;

        this.currentCompany = currentCompany;
        this.currentDesignation = currentDesignation;

        this.currentSalary = currentSalary;
        this.expectedSalary = expectedSalary;

        this.noticePeriod = noticePeriod;
        this.profileCompletion = profileCompletion;

        this.role = role;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getPortfolioUrl() {
        return portfolioUrl;
    }

    public void setPortfolioUrl(String portfolioUrl) {
        this.portfolioUrl = portfolioUrl;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public Integer getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(Integer graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public ExperienceType getExperienceType() {
        return experienceType;
    }

    public void setExperienceType(ExperienceType experienceType) {
        this.experienceType = experienceType;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getCurrentCompany() {
        return currentCompany;
    }

    public void setCurrentCompany(String currentCompany) {
        this.currentCompany = currentCompany;
    }

    public String getCurrentDesignation() {
        return currentDesignation;
    }

    public void setCurrentDesignation(String currentDesignation) {
        this.currentDesignation = currentDesignation;
    }

    public Double getcurrentSalary() {
        return currentSalary;
    }

    public void setcurrentSalary(Double curreentSalery) {
        this.currentSalary = curreentSalery;
    }

    public Double getexpectedSalary() {
        return expectedSalary;
    }

    public void setexpectedSalary(Double expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public String getNoticePeriod() {
        return noticePeriod;
    }

    public void setNoticePeriod(String noticePeriod) {
        this.noticePeriod = noticePeriod;
    }

    public Integer getProfileCompletion() {
        return profileCompletion;
    }

    public void setProfileCompletion(Integer profileCompletion) {
        this.profileCompletion = profileCompletion;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}