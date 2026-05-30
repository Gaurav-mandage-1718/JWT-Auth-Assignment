package com.assignment.service;

import com.assignment.DTO.AuthResponseDto;
import com.assignment.DTO.LoginRequestDto;
import com.assignment.DTO.RegisterRequestDto;

public interface AuthService {

    AuthResponseDto register(RegisterRequestDto registerRequestDto);

    AuthResponseDto login(LoginRequestDto loginRequestDto);
}