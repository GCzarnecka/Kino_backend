package com.kino.kino_backend.Service;

import com.kino.kino_backend.Entities.Reservation;
import com.kino.kino_backend.Entities.Seat;
import com.kino.kino_backend.Entities.User;
import com.kino.kino_backend.Repositories.ReservationRepository;
import com.kino.kino_backend.Repositories.SeatRepository;
import com.kino.kino_backend.Repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private SeatRepository seatRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addReservation_ValidReservation_ShouldAddReservationAndMarkSeatsAsTaken() {
        // Arrange
        Reservation reservation = new Reservation();

        reservation.setSeatsIds(List.of(1));
        Authentication authentication = mock(Authentication.class);
        SecurityContextHolder.setContext(new TestSecurityContext(authentication));
        when(authentication.getName()).thenReturn("test@example.com");
        var user = new User();
        user.setReservations(new ArrayList<>());
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));

        when(seatRepository.findById(1)).thenReturn(Optional.of(new Seat()));

        // Act
        userService.addReservation(reservation);

        // Assert
        assertTrue(user.getReservations().contains(reservation));
        verify(seatRepository, times(1)).save(any(Seat.class));
        assertDoesNotThrow(seatRepository.findById(1)::get);
        assertTrue(seatRepository.findById(1).get().isTaken());
    }

    @Test
    void addReservation_UserNotFound_ShouldThrowException() {
        // Arrange
        Reservation reservation = new Reservation();
        reservation.setSeatsIds(List.of(1, 2, 3));

        Authentication authentication = mock(Authentication.class);
        SecurityContextHolder.setContext(new TestSecurityContext(authentication));

        when(authentication.getName()).thenReturn("test@example.com");
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> userService.addReservation(reservation));

        verify(userRepository, never()).save(any(User.class));
        verify(seatRepository, never()).findById(anyInt());
        verify(seatRepository, never()).save(any(Seat.class));
    }

    @Test
    void placeOrder_SeatNotFound_ShouldThrowException() {
        // Arrange
        Reservation reservation = new Reservation();
        reservation.setSeatsIds(List.of(1, 2, 3));

        User user = new User();
        user.setReservations(new ArrayList<>());

        Authentication authentication = mock(Authentication.class);
        SecurityContextHolder.setContext(new TestSecurityContext(authentication));

        when(authentication.getName()).thenReturn("test@example.com");
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));

        when(seatRepository.findById(1)).thenReturn(Optional.of(new Seat()));
        when(seatRepository.findById(2)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> userService.addReservation(reservation));

        verify(userRepository, never()).save(any(User.class));
        verify(seatRepository, times(1)).findById(1);
        verify(seatRepository, times(1)).findById(2);
        verify(seatRepository, never()).findById(3);
        verify(seatRepository, never()).save(any(Seat.class));
    }

    @Test
    void getCurrentUser_UserExists_ShouldReturnUser() {
        // Arrange
        User user = new User();

        Authentication authentication = mock(Authentication.class);
        SecurityContextHolder.setContext(new TestSecurityContext(authentication));

        when(authentication.getName()).thenReturn("test@example.com");
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));

        // Act
        Optional<User> result = userService.getCurrentUser();

        // Assert
        assertTrue(result.isPresent());
        assertEquals(user, result.get());

        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void getCurrentUser_UserNotFound_ShouldReturnEmptyOptional() {
        // Arrange
        Authentication authentication = mock(Authentication.class);
        SecurityContextHolder.setContext(new TestSecurityContext(authentication));

        when(authentication.getName()).thenReturn("test@example.com");
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.empty());

        // Act
        Optional<User> result = userService.getCurrentUser();

        // Assert
        assertTrue(result.isEmpty());

        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void editReservation_ValidReservation_ShouldEditReservation() {
        // Arrange
        Reservation reservation = new Reservation();
        reservation.setId(1);
        reservation.setSeatsIds(List.of(1));

        Authentication authentication = mock(Authentication.class);
        SecurityContextHolder.setContext(new TestSecurityContext(authentication));
        when(authentication.getName()).thenReturn("test@example.com");
        var user = new User();
        user.setReservations(new ArrayList<>(){
            {
                add(reservation);
            }
        });
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));

        when(seatRepository.findById(1)).thenReturn(Optional.of(new Seat()));
        when(reservationRepository.findById(1)).thenReturn(Optional.of(reservation));

        reservation.setPaid(true);

        // Act
        userService.editReservation(reservation);

        // Assert that reservation saved in repository is paid
        assertDoesNotThrow(reservationRepository.findById(1)::get);
        assertTrue(reservationRepository.findById(1).get().isPaid());
    }

    @Test
    void deleteReservation_ExistingReservation_ShouldDeleteReservation() {
        // Arrange
        Integer reservationId = 1;
        Reservation reservation = new Reservation();
        reservation.setId(reservationId);

        User user = new User();
        user.setReservations(List.of(reservation));

        Authentication authentication = mock(Authentication.class);
        SecurityContextHolder.setContext(new TestSecurityContext(authentication));

        when(authentication.getName()).thenReturn("test@example.com");
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));
        when(reservationRepository.findById(reservationId)).thenReturn(Optional.of(reservation));

        // Act
        userService.deleteReservation(reservationId);

        // Assert
        assertFalse(user.getReservations().contains(reservation));

        verify(userRepository, times(1)).save(user);
        verify(reservationRepository, times(1)).delete(reservation);
    }

    @Test
    void deleteReservation_ReservationNotFound_ShouldThrowException() {
        // Arrange
        Integer reservationId = 1;
        Reservation reservation = new Reservation();
        reservation.setId(reservationId);

        User user = new User();
        user.setReservations(List.of(reservation));

        Authentication authentication = mock(Authentication.class);
        SecurityContextHolder.setContext(new TestSecurityContext(authentication));

        when(authentication.getName()).thenReturn("test@example.com");
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));
        when(reservationRepository.findById(reservationId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> userService.deleteReservation(reservationId));

        verify(userRepository, never()).save(any(User.class));
        verify(reservationRepository, never()).delete(any(Reservation.class));
    }

    private static class TestSecurityContext extends SecurityContextHolder implements SecurityContext {

        private final Authentication authentication;

        public TestSecurityContext(Authentication authentication) {
            this.authentication = authentication;
        }

        @Override
        public Authentication getAuthentication() {
            return authentication;
        }

        @Override
        public void setAuthentication(Authentication authentication) {
            throw new UnsupportedOperationException("setAuthentication is not supported");
        }
    }
}
