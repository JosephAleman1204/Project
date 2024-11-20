package com.aleman.project.project.jwt;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}

