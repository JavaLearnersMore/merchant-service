package com.example.security.config;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private final String SECRET =
            "my-secret-key-for-merchant-service-123456789";

    private final long EXPIRATION = 3600 * 1000;

    public String generateToken(Long merchantId, String username,
            String role) {

        Key key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .setSubject(username)
                .claim("merchantId", merchantId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(
                     System.currentTimeMillis() + EXPIRATION))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}