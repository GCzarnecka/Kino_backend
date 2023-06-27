package com.kino.kino_backend.Controllers.REST;

import com.kino.kino_backend.Entities.*;
import com.kino.kino_backend.Repositories.AuthorRepository;
import com.kino.kino_backend.Repositories.CategoryRepository;
import com.kino.kino_backend.Repositories.CinemaRoomRepository;
import com.kino.kino_backend.Service.MovieService;
import com.kino.kino_backend.Service.ScreeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CinemaController {

    @Autowired
    private CinemaRoomRepository cinemaRoomRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;


    private final MovieService movieService;

    private final ScreeningService screeningService;

    @GetMapping("/movies/{id}")
    @ResponseBody
    public Movie getMovie(@PathVariable Integer id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/movies")
    @ResponseBody
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping("/movies")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @PutMapping("/movies/{id}")
    public Movie updateMovie(@PathVariable Integer id, @RequestBody Movie movie) {
        Movie existingMovie = movieService.getMovieById(id);
        existingMovie.setTitle(movie.getTitle());
        // Update other properties as needed
        return movieService.updateMovie(existingMovie);
    }

    @GetMapping(value = "/screenings")
    @ResponseBody
    public List<Screening> getScreeningByMovieId(@RequestParam Integer movieId) {
        return screeningService.getScreeningByMovieId(movieId);
    }

    @PostMapping("/screenings")
    public Screening createScreening(@RequestBody Screening screening) {
        return screeningService.createScreening(screening);
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

}
