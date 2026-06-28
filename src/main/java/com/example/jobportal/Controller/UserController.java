package com.example.jobportal.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobportal.DTO.UserDto;
import com.example.jobportal.Services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get Logged-in User Profile
    @GetMapping("/profile")
    public ResponseEntity<UserDto> getProfile(Authentication authentication) {

        String email = authentication.getName();

        return ResponseEntity.ok(userService.getProfile(email));
    }

    // Update Logged-in User Profile
    @PutMapping("/profile")
    public ResponseEntity<String> updateProfile(
            Authentication authentication,
            @Valid @RequestBody UserDto userDto) {

        String email = authentication.getName();

        userService.updateProfile(email, userDto);

        return ResponseEntity.ok("Profile Updated Successfully");
    }
}