package com.kino.kino_backend.Controllers.REST;

import com.kino.kino_backend.Entities.Reservation;
import com.kino.kino_backend.Entities.User;
import com.kino.kino_backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/logged/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/place-order")
    public void placeOrder(@RequestBody Reservation reservation) {
        userService.addReservation(reservation);
    }

    @GetMapping("user")
    public Optional<User> user() {
        return userService.getCurrentUser();
    }

    @PostMapping("reservation")
    public void reservation(@RequestBody Reservation reservation) {
        userService.editReservation(reservation);
    }

    @DeleteMapping("reservation/{id}")
    public void deleteReservation(@PathVariable Integer id) {
        userService.deleteReservation(id);
    }
}
