package com.assignment.DTO;

import com.assignment.entity.Role;

import lombok.Data;

@Data
public class AuthResponseDto
{
	
	    private String token;
	    private int id;
	    private String name;
	    private String email;
	    private Role role;
}
