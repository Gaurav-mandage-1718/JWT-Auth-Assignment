package com.assignment.service;

import com.assignment.DTO.AuthResponseDto;
import com.assignment.DTO.LoginRequestDto;
import com.assignment.DTO.RegisterRequestDto;
import com.assignment.entity.User;
import com.assignment.repository.UserRepository;
import com.assignment.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService
{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public AuthResponseDto register(RegisterRequestDto registerRequestDto)
    {

      	if (userRepository.existsByEmail(registerRequestDto.getEmail())) 
      	{
    	    throw new RuntimeException("Email already registered");
      	}

        User user = new User();
        user.setName(registerRequestDto.getName());
        user.setEmail(registerRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));
        user.setRole(registerRequestDto.getRole());

        User savedUser = userRepository.save(user);

        String token = jwtService.generateToken(
                savedUser.getEmail(),
                savedUser.getRole().name()
        );

        AuthResponseDto response = new AuthResponseDto();
        response.setToken(token);
        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        response.setRole(savedUser.getRole());

        return response;
    }

    @Override
    public AuthResponseDto login(LoginRequestDto loginRequestDto) 
    {

        User user = userRepository.findByEmail(loginRequestDto.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        boolean passwordMatch = passwordEncoder.matches(
                loginRequestDto.getPassword(),
                user.getPassword()
        );

        if (!passwordMatch) {
            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtService.generateToken(
                user.getEmail(),
                user.getRole().name()
        );

        AuthResponseDto response = new AuthResponseDto();
        response.setToken(token);
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());

        return response;
    }
}