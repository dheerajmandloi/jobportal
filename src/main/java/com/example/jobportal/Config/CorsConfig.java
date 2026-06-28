package com.example.jobportal.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Sabhi endpoints par CORS apply karein
                        .allowedOrigins(
                                "http://127.0.0.1:5500",
                                "http://localhost:5500",
                                "http://localhost:3000",
                                "http://localhost:4200") // Frontend URLs (React/Angular) yahaan add karein
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH") // Allow kiye gaye HTTP
                                                                                            // Methods
                        .allowedHeaders("*") // Sabhi headers allow karein (Authorization, Content-Type, etc.)
                        .exposedHeaders("Authorization") // JWT token read karne ke liye frontend ko Authorization
                                                         // header expose karein
                        .allowCredentials(true) // Cookies ya Auth headers allow karne ke liye
                        .maxAge(3600); // Preflight requests ko 1 ghante tak cache karne ke liye
            }
        };
    }
}