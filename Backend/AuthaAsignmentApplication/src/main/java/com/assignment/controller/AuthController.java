package com.assignment.controller;

import com.assignment.DTO.AuthResponseDto;
import com.assignment.DTO.LoginRequestDto;
import com.assignment.DTO.RegisterRequestDto;
import com.assignment.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public AuthResponseDto register(@RequestBody RegisterRequestDto registerRequestDto) {
        return authService.register(registerRequestDto);
    }

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
        return authService.login(loginRequestDto);
    }
}