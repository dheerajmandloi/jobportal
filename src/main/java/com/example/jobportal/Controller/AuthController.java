package com.example.jobportal.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobportal.DTO.LoginRequestDto;
import com.example.jobportal.DTO.UserDto;
import com.example.jobportal.Services.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // FIX #5: @Valid lagaya - ab LoginRequestDto ke @NotBlank/@Email annotations
    // kaam karenge
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@Valid @RequestBody LoginRequestDto loginRequest) {
        UserDto userDto = new UserDto();
        userDto.setEmail(loginRequest.getEmail());
        userDto.setPassword(loginRequest.getPassword());

        String token = authService.loginUser(userDto);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {

        authService.registerUser(userDto);
        return ResponseEntity.ok("User Registered Successfully");
    }

    @PostMapping("/register/employer")
    public ResponseEntity<String> registerEmployer(@RequestBody UserDto userDto) {

        return ResponseEntity.ok(authService.registerEmployer(userDto));
    }
}
