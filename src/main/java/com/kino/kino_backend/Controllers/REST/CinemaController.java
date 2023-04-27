package com.kino.kino_backend.Controllers.REST;

import com.kino.kino_backend.Entities.*;
import com.kino.kino_backend.Exceptions.ResourceNotFoundException;
import com.kino.kino_backend.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CinemaController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ScreeningRepository screeningRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CinemaRoomRepository cinemaRoomRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MessageComplaintRepository messageComplaintRepository;

//    // Endpoint to get all users
//    @GetMapping("/users")
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    // Endpoint to get a user by id
//    @GetMapping("/users/{id}")
//    public User getUserById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
//        return userRepository.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
//    }
//
//    // Endpoint to create a new user
//    @PostMapping("/users")
//    public User createUser(@RequestBody User user) {
//        return userRepository.save(user);
//    }
//
//    // Endpoint to update a user
//    @PutMapping("/users/{id}")
//    public User updateUser(@PathVariable(value = "id") Long userId,  @RequestBody User userDetails) throws ResourceNotFoundException {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
//
//        user.setName(userDetails.getName());
//        user.setSurname(userDetails.getSurname());
//        user.setEmail(userDetails.getEmail());
//        user.setPassword(userDetails.getPassword());
//
//        return userRepository.save(user);
//    }
//
//    // Endpoint to delete a user
//    @DeleteMapping("/users/{id}")
//    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
//
//        userRepository.delete(user);
//
//        return ResponseEntity.ok().build();
//    }
//
    // Endpoint to get all movies
    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
//
//    // Endpoint to get a movie by id
//    @GetMapping("/movies/{id}")
//    public Movie getMovieById(@PathVariable(value = "id") Long movieId) throws ResourceNotFoundException {
//        return movieRepository.findById(movieId)
//                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + movieId));
//    }
//
    // Endpoint to create a new movie
//    @PostMapping("/movies")
    @RequestMapping(method = RequestMethod.POST, value = "/movies")
    public Movie createMovie( @RequestBody Movie movie) {
        return movieRepository.save(movie);
    }
//
//    // Endpoint to update a movie
//    @PutMapping("/movies/{id}")
//    public Movie updateMovie(@PathVariable(value = "id") Long movieId, @RequestBody Movie movieDetails) throws ResourceNotFoundException {
//        Movie movie = movieRepository.findById(movieId)
//                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + movieId));
//
//        movie.setTitle(movieDetails.getTitle());
//        movie.setProductionDate(movieDetails.getProductionDate());
//        movie.setDuration(movieDetails.getDuration());
//        movie.setAgeRestriction(movieDetails.getAgeRestriction());
//        movie.setAuthor(movieDetails.getAuthor());
//        movie.setCategory(movieDetails.getCategory());
//
//        return movieRepository.save(movie);
//    }
//
//    // Endpoint to delete a movie
//    @DeleteMapping("/movies/{ id }")
//    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
//        Optional<Movie> movie = movieRepository.findById(id);
//        if (movie.isPresent()) {
//            movieRepository.delete(movie.get());
//            return new ResponseEntity<>("Movie with id " + id + " has been deleted.", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Movie with id " + id + " was not found.", HttpStatus.NOT_FOUND);
//        }
//    }
//
//
//    // Endpoint to create a new reservation
//    @PostMapping("/reservations")
//    public ResponseEntity<String> createReservation(@RequestBody Reservation reservation) {
//        User user = reservation.getUser();
//        List<Seat> seats = reservation.getSeats();
//        Movie movie = (Movie) reservation.getMovies();
//
//        // Check if all seats are available for the movie screening
//        boolean allSeatsAvailable = seats.stream()
//                .allMatch(seat -> screeningRepository.isSeatAvailableForScreening(movie.getId(), seat.getId()));
//
//        if (allSeatsAvailable) {
//            // Set reservation time to current time
//            reservation.setReservationTime(LocalDateTime.now());
//
//            // Update screening seats to reserved
//            seats.forEach(seat -> {
//                Screening screening = screeningRepository.findByMovieAndCinemaRoom(movie, seat.getCinemaRoom());
//                screeningRepository.reserveSeat(screening.getId(), seat.getId());
//            });
//
//            // Save the reservation
//            reservationRepository.save(reservation);
//
//            return new ResponseEntity<>("Reservation created successfully.", HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>("One or more seats are already reserved.", HttpStatus.CONFLICT);
//        }
//    }
//
//    // Endpoint to get all reservations for a user
//    @GetMapping("/users/{userId}/reservations")
//    public ResponseEntity<List<Reservation>> getReservationsForUser(@PathVariable Long userId) {
//        Optional<User> user = userRepository.findById(userId);
//        if (user.isPresent()) {
//            List<Reservation> reservations = reservationRepository.findByUser(user.get());
//            return new ResponseEntity<>(reservations, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    // Endpoint to handle message complaints
//    @PostMapping("/complaints")
//    public ResponseEntity<String> handleComplaint(@RequestBody MessageComplaint complaint) {
//        // Send the complaint to the appropriate department
////        String department = complaint.getDepartment();
//        String message = complaint.getMessage();
//        // TODO: Add code to handle complaints
//
//        return new ResponseEntity<>("Complaint submitted successfully.", HttpStatus.CREATED);
//    }
}