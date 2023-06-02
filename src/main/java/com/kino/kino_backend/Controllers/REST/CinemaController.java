package com.kino.kino_backend.Controllers.REST;

import com.kino.kino_backend.Entities.*;
import com.kino.kino_backend.Exceptions.ResourceNotFoundException;
import com.kino.kino_backend.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping("/movies/{id}")
    @ResponseBody
    public Movie getMovie(@PathVariable Long id) {
        return  movieRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Movie not found with id: " + id));
    }

    @GetMapping("/movies")
    @ResponseBody
    public List<Movie> getAllMovies() {
        return  movieRepository.findAll();
    }


    @GetMapping("/categories")
    @ResponseBody
    public List<Category> getAllCategories() {
        return  categoryRepository.findAll();
    }

    @GetMapping("/rooms")
    @ResponseBody
    public List<CinemaRoom> getAllRooms() {
        return  cinemaRoomRepository.findAll();
    }

    @GetMapping("/authors")
    @ResponseBody
    public List<Author> getAllAuthors() {
        return  authorRepository.findAll();
    }


//    @RequestMapping(method = RequestMethod.POST, value = "/movies/{id}")
//    public Movie createMovie( @RequestBody Movie movie) {
//        return movieRepository.save(movie);
//    }
    @RequestMapping(method = RequestMethod.POST, value = "/movies")
    public Movie createMovie( @RequestBody Movie movie) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        if (!userOpt.get().getRole().equals(Role.ADMIN)) {
            throw new RuntimeException("User has no permissions!");
        }

        return movieRepository.save(movie);
    }
//    @RequestMapping(method = RequestMethod.POST, value = "/movies/{id}")
//    public Movie editMovie( @RequestBody Movie movie) {
//        return movieRepository.save(movie);
//    }


    @GetMapping( value="/screenings")
    @ResponseBody
        public List<Screening> getScreeningByMovieId( @RequestParam long movieId) {
            Movie movie = movieRepository.findById(movieId).orElseThrow(() ->
                    new ResourceNotFoundException("Movie not found with id: " + movieId));
            return screeningRepository.findByMovie(movie);
        }

    @PostMapping("/screenings")
    public Screening createScreening(@RequestBody Screening screening) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        if (!userOpt.get().getRole().equals(Role.ADMIN)) {
            throw new RuntimeException("User has no permissions!");
        }
        return screeningRepository.save(screening);
    }

}