package com.example.SolarLab.service;


import com.example.SolarLab.entity.User;
import com.example.SolarLab.entity.UserRole;
import com.example.SolarLab.repository.UserRepository;
import com.example.SolarLab.request.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;

    public void createNewAccount(SignupRequest request) {

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(request.getPassword());
        user.setRole(UserRole.USER);
        user.setIsAccountNonExpired(true);
        user.setIsAccountNonLocked(true);
        user.setIsCredentialsNonExpired(true);
        user.setIsEnabled(false);

        userRepository.save(user);
    }

}