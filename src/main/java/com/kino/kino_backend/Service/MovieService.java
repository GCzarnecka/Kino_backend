/**

 Service class for managing movie-related operations.
 */
package com.kino.kino_backend.Service;

import com.kino.kino_backend.Entities.Movie;
import com.kino.kino_backend.Exceptions.ResourceNotFoundException;
import com.kino.kino_backend.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;


    /**
     * Retrieves a movie by its ID.
     *
     * @param id the ID of the movie
     * @return the Movie object with the specified ID
     * @throws ResourceNotFoundException if the movie is not found
     */
    public Movie getMovieById(Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
    }


    /**
     * Retrieves all movies.
     *
     * @return a list of all movies
     */
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }



    /**
     * Creates a new movie.
     *
     * @param movie the Movie object to be created
     * @return the created Movie object
     * @throws IllegalArgumentException if the movie is null
     */
    public Movie createMovie(Movie movie) {
        if (movie == null) {
            throw new IllegalArgumentException("Movie can not be null");
        }
        return movieRepository.save(movie);
    }


    /**
     * Updates an existing movie.
     *
     * @param movie the Movie object to be updated
     * @return the updated Movie object
     * @throws IllegalArgumentException if the movie is null
     */
    public Movie updateMovie(Movie movie) {
        if (movie == null) {
            throw new IllegalArgumentException("Movie can not be null");
        }
        return movieRepository.save(movie);
    }

}
