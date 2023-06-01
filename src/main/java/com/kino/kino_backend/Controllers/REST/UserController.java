package com.kino.kino_backend.Controllers.REST;

import com.kino.kino_backend.Entities.Reservation;
import com.kino.kino_backend.Entities.User;
import com.kino.kino_backend.Repositories.ReservationRepository;
import com.kino.kino_backend.Repositories.SeatRepository;
import com.kino.kino_backend.Repositories.UserRepository;
import com.kino.kino_backend.auth.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/logged/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private SeatRepository seatRepository;


//    @PostMapping("/api/auth/register")
//    public ResponseEntity<Object> register(
//            @RequestBody RegisterRequest registerRequest
//    )
//    {
//        var resp = authenticationService.register(registerRequest);
//        if(resp == null)
//            return ResponseEntity.badRequest().body("User with provided email already exists!");
//        return ResponseEntity.ok(resp);
//    }

//    @PostMapping("/place-order")
    @RequestMapping(method = RequestMethod.POST, value = "/place-order")
    public void placeOrder(
            @RequestBody Reservation reservation
    ) {
        System.out.println("reservation " + reservation);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        var user = userOpt.get();
        var reservations = user.getReservations();

//        var reserv = Reservation.builder()
////                .id(reservation.getId())
//                .reservationTime(reservation.getReservationTime())
//                .screening(reservation.getScreening())
//                .seatsIds(reservation.getSeatsIds())
//                .archived(reservation.isArchived())
//                .price(reservation.getPrice())
//                .paid(reservation.isPaid())
//                .build();
//        reservationRepository.saveAndFlush(reservation);
        reservations.add(reservation);
        user.setReservations(reservations);
        userRepository.save(user);

        reservation.getSeatsIds().forEach(seatId -> {
            seatRepository.findById(seatId).ifPresent(seat -> {
                seat.setTaken(true);
                seatRepository.save(seat);
            });
        });
    }

    @GetMapping("user")
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
