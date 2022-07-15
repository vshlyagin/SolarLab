package com.example.SolarLab.configuration;


import com.example.SolarLab.entity.User;
import com.example.SolarLab.entity.UserRole;
import com.example.SolarLab.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Slf4j
@Configuration
public class InitDatabase {

    @Bean
    CommandLineRunner init(UserRepository userRepository) {

        User firstUser = new User("egor.filonchenko", "email@gmail.com", "+79780001122", "2222", UserRole.ADMINISTRATOR, true, true, true, true);
        User secondUser = new User("Valentin.Shlyagin", "email@yandex.ru", "+79780010001", "123456", UserRole.USER, true, true, true, true);


        return args -> {
            log.warn("Preloading data...");
            userRepository.save(firstUser);
            userRepository.save(secondUser);

        };
    }

}