/**

 The CinemaController class handles the REST API endpoints related to cinema operations.
 It provides functionality for managing movies, screenings, categories, cinema rooms, and authors.
 */

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


    /**
     * Handles the GET request to "/api/movies/{id}" endpoint.
     * This method retrieves a specific movie by its ID.
     *
     * @param id The ID of the movie.
     * @return The Movie object.
     */
    @GetMapping("/movies/{id}")
    @ResponseBody
    public Movie getMovie(@PathVariable Integer id) {
        return movieService.getMovieById(id);
    }


    /**
     * Handles the GET request to "/api/movies" endpoint.
     * This method retrieves all movies.
     *
     * @return A list of Movie objects.
     */
    @GetMapping("/movies")
    @ResponseBody
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }


    /**
     * Handles the POST request to "/api/movies" endpoint.
     * This method creates a new movie.
     *
     * @param movie The Movie object to be created.
     * @return The created Movie object.
     */
    @PostMapping("/movies")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    /**
     * Handles the PUT request to "/api/movies/{id}" endpoint.
     * This method updates an existing movie.
     *
     * @param id    The ID of the movie to be updated.
     * @param movie The updated Movie object.
     * @return The updated Movie object.
     */
    @PutMapping("/movies/{id}")
    public Movie updateMovie(@PathVariable Integer id, @RequestBody Movie movie) {
        Movie existingMovie = movieService.getMovieById(id);
        existingMovie.setTitle(movie.getTitle());
        // Update other properties as needed
        return movieService.updateMovie(existingMovie);
    }

    /**
     * Handles the GET request to "/api/screenings" endpoint.
     * This method retrieves all screenings of a movie by its ID.
     *
     * @param movieId The ID of the movie.
     * @return A list of Screening objects.
     */
    @GetMapping(value = "/screenings")
    @ResponseBody
    public List<Screening> getScreeningByMovieId(@RequestParam Integer movieId) {
        return screeningService.getScreeningByMovieId(movieId);
    }

    /**
     * Handles the POST request to "/api/screenings" endpoint.
     * This method creates a new screening.
     *
     * @param screening The Screening object to be created.
     * @return The created Screening object.
     */
    @PostMapping("/screenings")
    public Screening createScreening(@RequestBody Screening screening) {
        return screeningService.createScreening(screening);
    }

    /**
     * Handles the GET request to "/api/categories" endpoint.
     * This method retrieves all categories.
     *
     * @return A list of Category objects.
     */
    @GetMapping("/categories")
    @ResponseBody
    public List<Category> getAllCategories() {
        return  categoryRepository.findAll();
    }

    /**
     * Handles the GET request to "/api/rooms" endpoint.
     * This method retrieves all cinema rooms.
     *
     * @return A list of CinemaRoom objects.
     */
    @GetMapping("/rooms")
    @ResponseBody
    public List<CinemaRoom> getAllRooms() {
        return  cinemaRoomRepository.findAll();
    }

    /**
     * Handles the GET request to "/api/authors" endpoint.
     * This method retrieves all authors.
     *
     * @return A list of Author objects.
     */
    @GetMapping("/authors")
    @ResponseBody
    public List<Author> getAllAuthors() {
        return  authorRepository.findAll();
    }

}
