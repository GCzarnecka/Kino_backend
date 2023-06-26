package com.kino.kino_backend.Service;

import com.kino.kino_backend.Configuration.JwtService;
import com.kino.kino_backend.Entities.Role;
import com.kino.kino_backend.Entities.User;
import com.kino.kino_backend.Repositories.UserRepository;
import com.kino.kino_backend.Entities.auth.AuthenticationRequest;
import com.kino.kino_backend.Entities.auth.AuthenticationResponse;
import com.kino.kino_backend.Entities.auth.RegisterRequest;
import com.kino.kino_backend.Service.AuthenticationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class AuthenticationServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;

    private AuthenticationService authenticationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        authenticationService = new AuthenticationService(userRepository, passwordEncoder, jwtService, authenticationManager);
    }

    @Test
    void register_ValidRegisterRequest_ReturnsAuthenticationResponse() {
        // Arrange
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("test@example.com");
        registerRequest.setName("John");
        registerRequest.setSurname("Doe");
        registerRequest.setPassword("password");

        User user = User.builder()
                .email(registerRequest.getEmail())
                .name(registerRequest.getName())
                .surname(registerRequest.getSurname())
                .password("encodedPassword")
                .role(Role.USER)
                .build();

        when(passwordEncoder.encode(registerRequest.getPassword())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(jwtService.generateToken(user)).thenReturn("jwtToken");

        // Act
        AuthenticationResponse response = authenticationService.register(registerRequest);

        // Assert
        assertEquals("jwtToken", response.getToken());
    }

    @Test
    void register_ExceptionThrown_ReturnsNull() {
        // Arrange
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("test@example.com");
        registerRequest.setName("John");
        registerRequest.setSurname("Doe");
        registerRequest.setPassword("password");

        when(passwordEncoder.encode(registerRequest.getPassword())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenThrow(new RuntimeException());

        // Act
        AuthenticationResponse response = authenticationService.register(registerRequest);

        // Assert
        assertEquals(null, response);
    }

    @Test
    void login_ValidAuthenticationRequest_ReturnsAuthenticationResponse() {
        // Arrange
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setEmail("test@example.com");
        authenticationRequest.setPassword("password");

        User user = User.builder()
                .email(authenticationRequest.getEmail())
                .name("John")
                .surname("Doe")
                .password("encodedPassword")
                .role(Role.USER)
                .build();

        when(authenticationManager.authenticate(any())).thenReturn(null);
        when(userRepository.findByEmail(authenticationRequest.getEmail())).thenReturn(java.util.Optional.of(user));
        when(jwtService.generateToken(user)).thenReturn("jwtToken");

        // Act
        AuthenticationResponse response = authenticationService.login(authenticationRequest);

        // Assert
        assertEquals("jwtToken", response.getToken());
    }
}
