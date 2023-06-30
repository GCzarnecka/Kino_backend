/**

 The UserController class handles the REST API endpoints related to user operations.
 It provides functionality for managing user reservations and retrieving user information.
 */
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

    /**
     * Handles the POST request to "/logged/place-order" endpoint.
     * This method places a reservation order for the current user.
     *
     * @param reservation The Reservation object to be added.
     */
    @PostMapping("/place-order")
    public void placeOrder(@RequestBody Reservation reservation) {
        userService.addReservation(reservation);
    }

    /**
     * Handles the GET request to "/logged/user" endpoint.
     * This method retrieves the current user.
     *
     * @return An Optional object containing the User information.
     */
    @GetMapping("user")
    public Optional<User> user() {
        return userService.getCurrentUser();
    }

    /**
     * Handles the POST request to "/logged/reservation" endpoint.
     * This method edits an existing reservation for the current user.
     *
     * @param reservation The updated Reservation object.
     */
    @PostMapping("reservation")
    public void reservation(@RequestBody Reservation reservation) {
        userService.editReservation(reservation);
    }

    /**
     * Handles the DELETE request to "/logged/reservation/{id}" endpoint.
     * This method deletes a reservation for the current user by its ID.
     *
     * @param id The ID of the reservation to be deleted.
     */
    @DeleteMapping("reservation/{id}")
    public void deleteReservation(@PathVariable Integer id) {
        userService.deleteReservation(id);
    }
}
