package com.assignment.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/public")
    public String publicApi() {
        return "This is public API. Anyone can access this.";
    }

    @GetMapping("/user")
    public String userApi(Authentication authentication) {
        return "This is user API. Welcome " + authentication.getName();
    }

    @GetMapping("/admin")
    public String adminApi(Authentication authentication) {
        return "This is admin API. Welcome " + authentication.getName();
    }
}