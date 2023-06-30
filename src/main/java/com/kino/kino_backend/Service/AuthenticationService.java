/**

 Service class for user authentication and registration.
 */
package com.kino.kino_backend.Service;

import com.kino.kino_backend.Configuration.JwtService;
import com.kino.kino_backend.Entities.Role;
import com.kino.kino_backend.Entities.User;
import com.kino.kino_backend.Repositories.UserRepository;
import com.kino.kino_backend.Entities.auth.AuthenticationRequest;
import com.kino.kino_backend.Entities.auth.AuthenticationResponse;
import com.kino.kino_backend.Entities.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    /**
     * Registers a new user with the provided registration information.
     *
     * @param registerRequest the registration request containing user information
     * @return the authentication response containing a token
     */
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = User.builder()
                .email(registerRequest.getEmail())
                .name(registerRequest.getName())
                .surname(registerRequest.getSurname())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();

        try {
            userRepository.save(user);
        }
        catch (Exception e){
            return null;
        }
        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwt)
                .build();
    }
    private final AuthenticationManager authenticationManager;

    /**
     * Authenticates a user with the provided login credentials.
     *
     * @param authenticationRequest the authentication request containing login credentials
     * @return the authentication response containing a token
     */
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        var user = userRepository
                .findByEmail(authenticationRequest.getEmail())
                .orElseThrow();
        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwt)
                .build();

    }

    /**
     * Checks the permissions of the currently authenticated user.
     *
     * @return the User object representing the authenticated user with ADMIN role
     * @throws RuntimeException if the user is not found or has no permissions
     */
    public User checkPermissions() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        if (!userOpt.get().getRole().equals(Role.ADMIN)) {
            throw new RuntimeException("User has no permissions!");
        }
        return userOpt.get();
    }
}
