package com.example.SolarLab.service;

import com.example.SolarLab.entity.User;
import com.example.SolarLab.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findUserById(id).get();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Boolean deleteUserById(Long id) {
        userRepository.delete(userRepository.findUserById(id).get());

        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findUserByUsernameOrEmail(login, login).get();
    }
}
