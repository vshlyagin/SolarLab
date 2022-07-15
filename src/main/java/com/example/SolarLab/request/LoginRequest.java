package com.example.SolarLab.request;

import lombok.Data;

@Data
public class LoginRequest {

    private String login; // Username or E-mail address
    private String password;

}