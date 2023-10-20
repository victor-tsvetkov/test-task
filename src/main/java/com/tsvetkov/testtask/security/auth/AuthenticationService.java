package com.tsvetkov.testtask.security.auth;

import com.tsvetkov.testtask.dto.UserDto;
import com.tsvetkov.testtask.entities.User;
import com.tsvetkov.testtask.repositories.UserRepository;
import com.tsvetkov.testtask.security.jwt.JwtService;
import com.tsvetkov.testtask.services.UserService;
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
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public AuthenticationResponse register(RegisterRequest request) {
        UserDto userDto = new UserDto();
        userDto.setName(request.getName());
        userDto.setAge(request.getAge());
        userDto.setPassword(passwordEncoder.encode(request.getPassword()));
        String jwtToken = jwtService.generateToken(userService.addOrUpdateUser(userDto));
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user = userRepository.findByName(request.getUsername())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
