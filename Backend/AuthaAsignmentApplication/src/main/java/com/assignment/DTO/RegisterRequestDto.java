package com.assignment.DTO;

import com.assignment.entity.Role;

import lombok.Data;

@Data
public class RegisterRequestDto 
{
   private String name;
   private String email;
   private String password;
   private Role role;
}
