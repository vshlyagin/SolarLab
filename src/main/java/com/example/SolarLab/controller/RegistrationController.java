package com.example.SolarLab.controller;


import com.example.SolarLab.request.SignupRequest;
import com.example.SolarLab.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping(value = "")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping("/signup")
    public void createNewAccount(@RequestBody SignupRequest request) {
        registrationService.createNewAccount(request);
    }

}