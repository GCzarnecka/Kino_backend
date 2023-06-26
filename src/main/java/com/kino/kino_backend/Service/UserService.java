package com.kino.kino_backend.Service;

import com.kino.kino_backend.Entities.Reservation;
import com.kino.kino_backend.Entities.User;
import com.kino.kino_backend.Repositories.ReservationRepository;
import com.kino.kino_backend.Repositories.SeatRepository;
import com.kino.kino_backend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private SeatRepository seatRepository;

    public void addReservation(Reservation reservation) {
        System.out.println("reservation " + reservation);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        var seats = reservation.getSeatsIds()
                .stream().map(seatId -> seatRepository.findById(seatId).orElseThrow(
                () -> new RuntimeException("Seat not found")
        )).toList();

        seats.forEach(seat -> {
            seat.setTaken(true);
            seatRepository.save(seat);
        });

        var user = userOpt.get();
        var reservations = user.getReservations();
        reservations.add(reservation);
        user.setReservations(reservations);
        userRepository.save(user);
    }

    public Optional<User> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userRepository.findByEmail(email);
    }

    public void editReservation(Reservation reservation) {
        checkReservationUser(reservation);
        reservationRepository.save(reservation);
    }

    public void deleteReservation(Integer id) {
        var reservation = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found"));
        var user = checkReservationUser(reservation);
        user.setReservations(user.getReservations().stream().filter(res -> res.getId() != id).toList());
        reservationRepository.delete(reservation);
        userRepository.save(user);
    }

    private User checkReservationUser(Reservation reservation) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        if (!userOpt.get().getReservations().stream().anyMatch(res -> res.getId() == reservation.getId())) {
            throw new RuntimeException("Reservation does not belong to user!");
        }
        return userOpt.get();
    }
}
