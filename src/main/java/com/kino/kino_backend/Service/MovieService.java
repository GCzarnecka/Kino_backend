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

    public Movie getMovieById(Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie createMovie(Movie movie) {
        if (movie == null) {
            throw new IllegalArgumentException("Movie can not be null");
        }
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie) {
        if (movie == null) {
            throw new IllegalArgumentException("Movie can not be null");
        }
        return movieRepository.save(movie);
    }

}
