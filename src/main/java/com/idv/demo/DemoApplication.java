package com.idv.demo;

import com.idv.demo.security.entity.UserEntity;
import com.idv.demo.security.models.RegisterRequest;
import com.idv.demo.security.models.Roles;
import com.idv.demo.security.repository.UserRepository;
import com.idv.demo.security.service.AuthenticationService;
import java.util.Arrays;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
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
        RegisterRequest userRequest = new RegisterRequest();
        userRequest.setPassword("idv123");
        userRequest.setEmail("emre@idv.com");
        userRequest.setRoles(Arrays.asList(Roles.IK));
        this.authenticationService.register(userRequest);
    }
}
