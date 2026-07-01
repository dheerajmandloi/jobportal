package com.example.jobportal.Services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.jobportal.Config.JwtUtil;
import com.example.jobportal.DTO.UserDto;
import com.example.jobportal.Model.Role;
import com.example.jobportal.Model.User;
import com.example.jobportal.Repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    // Constructor Injection (Best Practice)
    public AuthService(UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil,
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    // FIX #1: Ab actually user save hoga DB mein + password encode hoga
    public String registerUser(UserDto userDto) {
        // Check: Email pehle se registered toh nahi?
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new RuntimeException("Email already registered: " + userDto.getEmail());
        }

        User user = new User();
        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());
        // FIX: Plain text password nahi, BCrypt encoded password save hoga
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setPhoneNumber(userDto.getPhoneNumber());
        // Default role JOB_SEEKER, ya DTO se jo aaye
        user.setRole(Role.JOB_SEEKER);
        user.setActive(true);

        userRepository.save(user);
        return "User Registered Successfully";
    }

    // FIX #2: Actual authentication + JWT token generate hoga
    public String loginUser(UserDto userDto) {
        // Spring Security se authenticate karwao (password BCrypt check karega
        // automatically)
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()));

        // Authentication successful - JWT token banao
        UserDetails userDetails = userDetailsService.loadUserByUsername(userDto.getEmail());
        return jwtUtil.generateToken(userDetails);
    }

    public String registerEmployer(UserDto userDto) {

        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new RuntimeException("Email already registered: " + userDto.getEmail());
        }

        User user = new User();

        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setPhoneNumber(userDto.getPhoneNumber());

        // 👇 Employer role
        user.setRole(Role.EMPLOYER);

        user.setActive(true);

        userRepository.save(user);

        return "Employer Registered Successfully";
    }
}
