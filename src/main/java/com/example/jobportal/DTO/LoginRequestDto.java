package com.example.jobportal.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequestDto {

    @NotBlank(message = "Email khali nahi ho sakta")
    @Email(message = "Valid email format dalein (e.g., user@example.com)")
    private String email;

    @NotBlank(message = "Password khali nahi ho sakta")
    private String password;

    // Default Constructor (Jackson serialization/deserialization ke liye zaroori hai)
    public LoginRequestDto() {
    }

    // Parameterized Constructor
    public LoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters aur Setters
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
}