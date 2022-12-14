package com.iti0207.parkla.controller;

import com.iti0207.parkla.dto.LoginRequestDto;
import com.iti0207.parkla.dto.LoginResponseDto;
import com.iti0207.parkla.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("api/public/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto requestDto) {
        Optional<LoginResponseDto> dto = authService.login(requestDto.getEmail(), requestDto.getPassword());
        return dto.map(loginResponseDto -> new ResponseEntity<>(loginResponseDto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}