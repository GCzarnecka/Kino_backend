package com.kino.kino_backend.Controllers.REST;

import com.kino.kino_backend.Entities.auth.AuthenticationRequest;
import com.kino.kino_backend.Service.AuthenticationService;
import com.kino.kino_backend.Entities.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    @PostMapping("/api/auth/login")//AuthenticationResponse
    public ResponseEntity<Object> login(
            @RequestBody AuthenticationRequest authenticationRequest
    )
    {
    return ResponseEntity.ok(authenticationService.login(authenticationRequest));
    }
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