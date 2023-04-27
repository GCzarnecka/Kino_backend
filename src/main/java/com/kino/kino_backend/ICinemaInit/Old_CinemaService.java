//package com.kino.kino_backend.ICinemaInit;
//
//import com.kino.kino_backend.Entities.Movie;
//import com.kino.kino_backend.Entities.Screening;
//import com.kino.kino_backend.Entities.CinemaRoom;
//import com.kino.kino_backend.Entities.Category;
//import com.kino.kino_backend.Entities.User;
//import com.kino.kino_backend.Entities.Reservation;
//import com.kino.kino_backend.Entities.MessageComplaint;
//import com.kino.kino_backend.Exceptions.ResourceNotFoundException;
//
//import java.util.List;
//
//
//public interface Old_CinemaService {
//    List<Movie> getAllMovies();
//
//    Movie getMovieById(int id) throws ResourceNotFoundException;
//
//    Movie addMovie(Movie movie);
//
//    Movie createMovie(Movie movie);
//
//    Movie updateMovie(int id, Movie movieDetails) throws ResourceNotFoundException;
//
//    void deleteMovie(int id) throws ResourceNotFoundException;
//
//    List<Screening> getAllScreenings();
//
//    Screening getScreeningById(int id) throws ResourceNotFoundException;
//
//    Screening addScreening(Screening screening);
//
//    Screening createScreening(Screening screening);
//
//    Screening updateScreening(int id, Screening screeningDetails) throws ResourceNotFoundException;
//
//    void deleteScreening(int id) throws ResourceNotFoundException;
//
//    List<CinemaRoom> getAllCinemaRooms();
//
//    CinemaRoom getCinemaRoomById(int id) throws ResourceNotFoundException;
//
//    CinemaRoom addCinemaRoom(CinemaRoom cinemaRoom);
//
//    CinemaRoom updateCinemaRoom(int id, CinemaRoom cinemaRoomDetails) throws ResourceNotFoundException;
//
//    void deleteCinemaRoom(int id) throws ResourceNotFoundException;
//
//    List<Category> getAllCategories();
//
//    Category getCategoryById(int id) throws ResourceNotFoundException;
//
//    Category addCategory(Category category);
//
//    Category updateCategory(int id, Category categoryDetails) throws ResourceNotFoundException;
//
//    void deleteCategory(int id) throws ResourceNotFoundException;
//
//    List<User> getAllUsers();
//
//    User getUserById(int id) throws ResourceNotFoundException;
//
//    User addUser(User user);
//
//    User updateUser(int id, User userDetails) throws ResourceNotFoundException;
//
//    void deleteUser(int id) throws ResourceNotFoundException;
//
//    List<Reservation> getAllReservations();
//
//    Reservation getReservationById(int id) throws ResourceNotFoundException;
//
//    Reservation addReservation(Reservation reservation);
//
//    Reservation updateReservation(int id, Reservation reservationDetails) throws ResourceNotFoundException;
//
//    Reservation createReservation(Reservation reservation);
//
//    void deleteReservation(int id) throws ResourceNotFoundException;
//
//    List<MessageComplaint> getAllMessageComplaints();
//
//    MessageComplaint getMessageComplaintById(int id) throws ResourceNotFoundException;
//
//    MessageComplaint addMessageComplaint(MessageComplaint messageComplaint);
//
//    MessageComplaint updateMessageComplaint(int id, MessageComplaint messageComplaintDetails) throws ResourceNotFoundException;
//
//    void deleteMessageComplaint(int id) throws ResourceNotFoundException;
//}
