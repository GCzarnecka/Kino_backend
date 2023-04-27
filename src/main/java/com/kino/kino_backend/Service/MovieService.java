//package com.kino.kino_backend.Service;
//
//import com.kino.kino_backend.Entities.Movie;
//import com.kino.kino_backend.Repositories.MovieRepository;
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class MovieService {
//
//    private final MovieRepository movieRepository;
//
//    public MovieService(MovieRepository movieRepository) {
//        this.movieRepository = movieRepository;
//    }
//
//    public List<Movie> getAllMovies() {
//        return movieRepository.findAll();
//    }
//
//    public Movie getMovieById(long id) {
//        Optional<Movie> movie = movieRepository.findById(id);
//        if (movie.isPresent()) {
//            return movie.get();
//        } else {
//            throw new EntityNotFoundException("Movie with id " + id + " not found.");
//        }
//    }
//
//    public Movie addMovie(Movie movie) {
//        return movieRepository.save(movie);
//    }
//
//    public void deleteMovie(long id) {
//        Optional<Movie> movie = movieRepository.findById(id);
//        if (movie.isPresent()) {
//            movieRepository.delete(movie.get());
//        } else {
//            throw new EntityNotFoundException("Movie with id " + id + " not found.");
//        }
//    }
//
//    public Movie updateMovie(long id, Movie updatedMovie) {
//        Optional<Movie> movie = movieRepository.findById(id);
//        if (movie.isPresent()) {
//            Movie movieToUpdate = movie.get();
//            movieToUpdate.setTitle(updatedMovie.getTitle());
//            movieToUpdate.setDuration(updatedMovie.getDuration());
//            movieToUpdate.setProductionDate(updatedMovie.getProductionDate());
//            movieToUpdate.setAgeRestriction(updatedMovie.getAgeRestriction());
//            movieToUpdate.setAuthor(updatedMovie.getAuthor());
//            movieToUpdate.setCategories(updatedMovie.getCategories());
//            return movieRepository.save(movieToUpdate);
//        } else {
//            throw new EntityNotFoundException("Movie with id " + id + " not found.");
//        }
//    }
//
//}
