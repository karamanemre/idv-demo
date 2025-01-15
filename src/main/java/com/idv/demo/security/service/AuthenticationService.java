package com.idv.demo.security.service;


import com.idv.demo.security.entity.UserEntity;
import com.idv.demo.models.dtos.auth.LoginUserRequest;
import com.idv.demo.models.dtos.auth.RegisterUserRequest;
import com.idv.demo.security.repository.UserRepository;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public UserEntity signup(RegisterUserRequest input) {
        UserEntity user = UserEntity.builder()
                .email(input.getEmail())
                .roles(Arrays.asList("IK"))
                .password(passwordEncoder.encode(input.getPassword()))
                .build();

        return userRepository.save(user);
    }

    public UserEntity authenticate(LoginUserRequest input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
