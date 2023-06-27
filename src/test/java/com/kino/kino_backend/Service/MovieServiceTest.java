package com.kino.kino_backend.Service;

import com.kino.kino_backend.Entities.Movie;
import com.kino.kino_backend.Exceptions.ResourceNotFoundException;
import com.kino.kino_backend.Repositories.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetMovieById() {
        // Arrange
        Integer movieId = 1;
        Movie movie = new Movie();
        movie.setId(movieId);
        when(movieRepository.findById(movieId)).thenReturn(Optional.of(movie));

        // Act
        Movie result = movieService.getMovieById(movieId);

        // Assert
        assertNotNull(result);
        assertEquals(movieId, result.getId());
    }

    @Test
    void testGetMovieById_ThrowsException() {
        // Arrange
        Integer movieId = 1;
        when(movieRepository.findById(movieId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> movieService.getMovieById(movieId));
    }

    @Test
    void testGetAllMovies() {
        // Arrange
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie());
        movies.add(new Movie());
        when(movieRepository.findAll()).thenReturn(movies);

        // Act
        List<Movie> result = movieService.getAllMovies();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void testCreateMovie() {
        // Arrange
        Movie movie = new Movie();
        when(movieRepository.save(movie)).thenReturn(movie);

        // Act
        Movie result = movieService.createMovie(movie);

        // Assert
        assertNotNull(result);
        assertEquals(movie, result);
        verify(movieRepository, times(1)).save(movie);
    }

    @Test
    void testUpdateMovie() {
        // Arrange
        Movie movie = new Movie();
        when(movieRepository.save(movie)).thenReturn(movie);

        // Act
        Movie result = movieService.updateMovie(movie);

        // Assert
        assertNotNull(result);
        assertEquals(movie, result);
        verify(movieRepository, times(1)).save(movie);
    }

    @Test
    void testCreateMovie_NullMovie() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> movieService.createMovie(null));
        verify(movieRepository, never()).save(any());
    }

    @Test
    void testUpdateMovie_NullMovie() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> movieService.updateMovie(null));
        verify(movieRepository, never()).save(any());
    }

    @Test
    void testGetMovieById_InvalidId() {
        // Arrange
        Integer invalidId = 999;
        when(movieRepository.findById(invalidId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> movieService.getMovieById(invalidId));
    }

    @Test
    void testGetAllMovies_EmptyList() {
        // Arrange
        when(movieRepository.findAll()).thenReturn(Collections.emptyList());

        // Act
        List<Movie> result = movieService.getAllMovies();

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetAllMovies_ExceptionThrown() {
        // Arrange
        when(movieRepository.findAll()).thenThrow(RuntimeException.class);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> movieService.getAllMovies());
    }

}

