package com.iti0207.parkla.service;

import com.iti0207.parkla.config.JwtTokenProvider;
import com.iti0207.parkla.dto.LoginResponseDto;
import com.iti0207.parkla.repository.AuthRepository;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {
    private final AuthRepository authRepository;

    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public Optional<LoginResponseDto> login(String email, String password) {
        Object kasutaja = authRepository.getAllParkimiskoht(email, password);
        if (kasutaja.equals(true)) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("email", email);
            claims.put("auth", "JUHATAJA");
            String token = getToken(claims);

            LoginResponseDto response = new LoginResponseDto();
            response.setToken(token);
            response.setEmail(email);

            return Optional.of(response);
        } else {
            return Optional.empty();
        }
    }


    private String getToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setSubject("Admin")
                .addClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 14 * 24 * 60 * 60 * 1000))
                .signWith(JwtTokenProvider.key)
                .compact();
    }

}