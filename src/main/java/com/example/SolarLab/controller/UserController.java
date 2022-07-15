package com.example.SolarLab.controller;

import com.example.SolarLab.entity.User;
import com.example.SolarLab.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> getUserAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/get/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users/save/")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/users/delete/{id}")
    public Boolean deleteUser(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }

}