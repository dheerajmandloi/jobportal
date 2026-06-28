package com.example.jobportal.Config;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    // Best Practice: Properties file se value load karein (No Hardcoding)
    @Value("${jwt.secret:YourSecretKeyForJobPortalApplication12345678901234567890}")
    private String secretKeyString;

    @Value("${jwt.expiration:36000000}") // Default: 10 Hours in milliseconds
    private long jwtExpirationTime;

    // String key ko SecretKey object me convert karne ka tareeqa (JJWT 0.12.x style)
    private SecretKey getSigningKey() {
        byte[] keyBytes = secretKeyString.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // 1. Generate Token with Custom Claims (Email aur Role)
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        
        // Subject me email/username jayega aur claims me authorities (roles)
        claims.put("email", userDetails.getUsername());
        claims.put("role", userDetails.getAuthorities().stream()
                .map(auth -> auth.getAuthority())
                .findFirst()
                .orElse("JOB_SEEKER")); // Default fallback role

        return createToken(claims, userDetails.getUsername());
    }

    // Token creation logic using latest JJWT fluent API
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + jwtExpirationTime))
                .signWith(getSigningKey()) // Modern syntax without deprecation
                .compact();
    }

    // 2. Extract Username (Email) from Token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // 3. Extract Expiration Date
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Custom claim nikalne ke liye generic method (Jaise Role extract karna ho)
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Claims parse karne ka modern builder syntax
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey()) // JJWT 0.12.x standard
                .build()
                .parseSignedClaims(token)
                .getPayload(); // .getBody() is deprecated, .getPayload() is preferred
    }

    // 4. Check if Token is Expired
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // 5. Validate Token
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}