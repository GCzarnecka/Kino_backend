/**

 The AuthenticationController class handles the REST API endpoints related to authentication.
 It provides functionality for user login and registration.
 */
package com.kino.kino_backend.Controllers.REST;

import com.kino.kino_backend.Entities.auth.AuthenticationRequest;
import com.kino.kino_backend.Service.AuthenticationService;
import com.kino.kino_backend.Entities.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    /**
     * Handles the POST request to "/api/auth/login" endpoint.
     * This method allows a user to log in with their credentials.
     *
     * @param authenticationRequest The AuthenticationRequest object containing user credentials.
     * @return ResponseEntity with the response body.
     */
    @PostMapping("/api/auth/login")
    public ResponseEntity<Object> login(
            @RequestBody AuthenticationRequest authenticationRequest
    )
    {
    return ResponseEntity.ok(authenticationService.login(authenticationRequest));
    }

    /**
     * Handles the POST request to "/api/auth/register" endpoint.
     * This method allows a user to register a new account.
     *
     * @param registerRequest The RegisterRequest object containing user registration details.
     * @return ResponseEntity with the response body.
     */
    @PostMapping("/api/auth/register")
    public ResponseEntity<Object> register(
        @RequestBody RegisterRequest registerRequest
    )
    {
        var resp = authenticationService.register(registerRequest);
        if(resp == null)
            return ResponseEntity.badRequest().body("User with provided email already exists!");
        return ResponseEntity.ok(resp);
    }


}
