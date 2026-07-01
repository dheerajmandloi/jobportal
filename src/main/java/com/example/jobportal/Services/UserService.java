package com.example.jobportal.Services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.jobportal.DTO.UserDto;
import com.example.jobportal.Model.User;
import com.example.jobportal.Repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singletonList(
                        new SimpleGrantedAuthority("ROLE_" + user.getRole().name())));
    }

    public UserDto getProfile(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        UserDto dto = new UserDto();

        dto.setUserId(user.getUserId());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setPhoneNumber(user.getPhoneNumber());

        dto.setProfileImage(user.getProfileImage());
        dto.setResumeUrl(user.getResumeUrl());

        dto.setGithubUrl(user.getGithubUrl());
        dto.setLinkedinUrl(user.getLinkedinUrl());
        dto.setPortfolioUrl(user.getPortfolioUrl());

        dto.setQualification(user.getQualification());
        dto.setCollegeName(user.getCollegeName());
        dto.setCgpa(user.getCgpa());
        dto.setGraduationYear(user.getGraduationYear());

        dto.setSkills(user.getSkills());

        dto.setCurrentCity(user.getCurrentCity());

        dto.setExperienceType(user.getExperienceType());
        dto.setExperienceYears(user.getExperienceYears());

        dto.setCurrentCompany(user.getCurrentCompany());
        dto.setCurrentDesignation(user.getCurrentDesignation());

        dto.setcurrentSalary(user.getcurrentSalary());
        dto.setexpectedSalary(user.getexpectedSalary());

        dto.setNoticePeriod(user.getNoticePeriod());

        dto.setProfileCompletion(user.getProfileCompletion());

        dto.setRole(user.getRole());

        return dto;
    }

    public void updateProfile(String email, UserDto userDto) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        user.setFullName(userDto.getFullName());
        user.setPhoneNumber(userDto.getPhoneNumber());

        user.setProfileImage(userDto.getProfileImage());
        user.setResumeUrl(userDto.getResumeUrl());

        user.setGithubUrl(userDto.getGithubUrl());
        user.setLinkedinUrl(userDto.getLinkedinUrl());
        user.setPortfolioUrl(userDto.getPortfolioUrl());

        user.setQualification(userDto.getQualification());
        user.setCollegeName(userDto.getCollegeName());
        user.setCgpa(userDto.getCgpa());
        user.setGraduationYear(userDto.getGraduationYear());

        user.setSkills(userDto.getSkills());

        user.setCurrentCity(userDto.getCurrentCity());

        user.setExperienceType(userDto.getExperienceType());
        user.setExperienceYears(userDto.getExperienceYears());

        user.setCurrentCompany(userDto.getCurrentCompany());
        user.setCurrentDesignation(userDto.getCurrentDesignation());

        user.setcurrentSalary(userDto.getcurrentSalary());
        user.setexpectedSalary(userDto.getexpectedSalary());

        user.setNoticePeriod(userDto.getNoticePeriod());

        user.setProfileCompletion(userDto.getProfileCompletion());

        // Email, Password aur Role update nahi honge

        userRepository.save(user);
    }

    public String uploadResume(String email, MultipartFile resumeFile) {

        try {

            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            if (resumeFile.isEmpty()) {
                throw new RuntimeException("Resume file is empty");
            }

            String uploadDir = "uploads/resumes/";

            Files.createDirectories(Paths.get(uploadDir));

            String fileName = System.currentTimeMillis() + "_" + resumeFile.getOriginalFilename();

            Path filePath = Paths.get(uploadDir, fileName);

            Files.copy(resumeFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            user.setResumeUrl("/uploads/resumes/" + fileName);

            userRepository.save(user);

            return user.getResumeUrl();

        } catch (IOException e) {
            throw new RuntimeException("Resume upload failed");
        }
    }
}