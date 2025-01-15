package com.idv.demo;

import com.idv.demo.models.dtos.auth.RegisterUserRequest;
import com.idv.demo.security.entity.UserEntity;
import com.idv.demo.security.repository.UserRepository;
import com.idv.demo.security.service.AuthenticationService;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AuthenticationService authenticationService;

    public DemoApplication(UserRepository userRepository, AuthenticationService authenticationService) {
        this.userRepository = userRepository;
        this.authenticationService = authenticationService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Optional<UserEntity> user = userRepository.findByEmail("emre@idv.com");
        if (user.isPresent()) {
            return;
        }
        RegisterUserRequest userRequest = new RegisterUserRequest();
        userRequest.setPassword("idv123");
        userRequest.setEmail("emre@idv.com");
        this.authenticationService.signup(userRequest);
    }
}
