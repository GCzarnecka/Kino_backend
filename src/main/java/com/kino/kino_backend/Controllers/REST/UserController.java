package com.kino.kino_backend.Controllers.REST;

import com.kino.kino_backend.Entities.User;
import com.kino.kino_backend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/logged/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public Optional<User> user() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userRepository.findByEmail(email);
    }


//    @GetMapping("/history")
//    public Optional<User> history() {
//
//    }

}
