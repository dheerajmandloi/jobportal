package com.example.jobportal.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    private final UserDetailsService userDetailsService;

    public SecurityConfig(JwtFilter jwtFilter, UserDetailsService userDetailsService) {
        this.jwtFilter = jwtFilter;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())

                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests(auth -> auth

                        // Static Files
                        .requestMatchers(
                                "/",
                                "/index.html",
                                "/css/**",
                                "/js/**",
                                "/images/**",
                                "/uploads/**",
                                "/assets/**",
                                "/User/**",
                                "/Admin/**")
                        .permitAll()

                        // Authentication
                        .requestMatchers("/api/auth/**").permitAll()

                        // User APIs
                        .requestMatchers("/api/user/**")
                        .authenticated()

                        // Jobs
                        .requestMatchers(HttpMethod.GET, "/api/jobs/**").permitAll()

                        .requestMatchers(HttpMethod.POST, "/api/jobs/create")
                        .hasAnyRole("EMPLOYER", "ADMIN")

                        .requestMatchers(HttpMethod.PUT, "/api/jobs/**")
                        .hasAnyRole("EMPLOYER", "ADMIN")

                        .requestMatchers(HttpMethod.DELETE, "/api/jobs/**")
                        .hasAnyRole("EMPLOYER", "ADMIN")

                        // Companies
                        .requestMatchers(HttpMethod.GET, "/api/company/**").permitAll()

                        .requestMatchers(HttpMethod.POST, "/api/company/create")
                        .hasAnyRole("EMPLOYER", "ADMIN")

                        .requestMatchers(HttpMethod.PUT, "/api/company/**")
                        .hasAnyRole("EMPLOYER", "ADMIN")

                        .requestMatchers(HttpMethod.DELETE, "/api/company/**")
                        .hasAnyRole("EMPLOYER", "ADMIN")

                        // Applications

                        .requestMatchers(HttpMethod.POST, "/api/application/apply")
                        .hasRole("JOB_SEEKER")

                        .requestMatchers(HttpMethod.GET, "/api/application/**")
                        .authenticated()

                        .requestMatchers(HttpMethod.DELETE, "/api/application/**")
                        .hasAnyRole("JOB_SEEKER", "ADMIN")

                        // Admin
                        .requestMatchers("/api/admin/**")
                        .hasRole("ADMIN")

                        // Everything else
                        .anyRequest().authenticated())

                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
            throws Exception {
        return configuration.getAuthenticationManager();
    }
}