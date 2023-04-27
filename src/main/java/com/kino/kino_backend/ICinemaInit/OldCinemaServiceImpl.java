//package com.kino.kino_backend.ICinemaInit;
//
//
//import com.kino.kino_backend.Entities.*;
//import com.kino.kino_backend.Exceptions.ResourceNotFoundException;
//import com.kino.kino_backend.Repositories.MovieRepository;
//import com.kino.kino_backend.Repositories.ReservationRepository;
//import com.kino.kino_backend.Repositories.ScreeningRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class OldCinemaServiceImpl implements Old_CinemaService {
//
//    private final MovieRepository movieRepository;
//    private final ScreeningRepository screeningRepository;
//    private final ReservationRepository reservationRepository;
//
//    public OldCinemaServiceImpl(MovieRepository movieRepository, ScreeningRepository screeningRepository, ReservationRepository reservationRepository) {
//        this.movieRepository = movieRepository;
//        this.screeningRepository = screeningRepository;
//        this.reservationRepository = reservationRepository;
//    }
//
//    @Override
//    public List<Movie> getAllMovies() {
//        return movieRepository.findAll();
//    }
//
//    @Override
//    public Movie getMovieById(long id) throws ResourceNotFoundException {
//        return movieRepository.findById((id));//.orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
//    }
//
//    @Override
//    public Movie addMovie(Movie movie) {
//        return null;
//    }
//
//    @Override
//    public Movie createMovie(Movie movie) {
//        return movieRepository.save(movie);
//    }
//
//    @Override
//    public Movie updateMovie(int id,  Movie updatedMovie) throws ResourceNotFoundException {
//        Movie movie = getMovieById(id);
//        movie.setTitle(updatedMovie.getTitle());
//        movie.setProductionDate(updatedMovie.getProductionDate());
//        movie.setAgeRestriction(updatedMovie.getAgeRestriction());
//        movie.setDuration(updatedMovie.getDuration());
//        movie.setAuthor(updatedMovie.getAuthor());
//        return movieRepository.save(movie);
//    }
//
//    @Override
//    public void deleteMovie(int id) throws ResourceNotFoundException {
//        Movie movie = getMovieById(id);
//        movieRepository.delete(movie);
//    }
//
//    @Override
//    public List<Screening> getAllScreenings() {
//        return screeningRepository.findAll();
//    }
//
//    @Override
//    public Screening getScreeningById(int id) throws ResourceNotFoundException {
//        return screeningRepository.findById((long) id).orElseThrow(() -> new ResourceNotFoundException("Screening not found"));
//    }
//
//    @Override
//    public Screening addScreening(Screening screening) {
//        return null;
//    }
//
//    @Override
//    public Screening createScreening(Screening screening) {
//        return screeningRepository.save(screening);
//    }
//
//    @Override
//    public Screening updateScreening(int id, Screening updatedScreening) throws ResourceNotFoundException {
//        Screening screening = getScreeningById(id);
////        screening.setStartTime(updatedScreening.getStartTime());
//        screening.setMovie(updatedScreening.getMovie());
//        screening.setCinemaRoom(updatedScreening.getCinemaRoom());
//        return screeningRepository.save(screening);
//    }
//
//    @Override
//    public void deleteScreening(int id) throws ResourceNotFoundException {
//        Screening screening = getScreeningById(id);
//        screeningRepository.delete(screening);
//    }
//
//    @Override
//    public List<CinemaRoom> getAllCinemaRooms() {
//        return null;
//    }
//
//    @Override
//    public CinemaRoom getCinemaRoomById(int id) throws ResourceNotFoundException {
//        return null;
//    }
//
//    @Override
//    public CinemaRoom addCinemaRoom(CinemaRoom cinemaRoom) {
//        return null;
//    }
//
//    @Override
//    public CinemaRoom updateCinemaRoom(int id, CinemaRoom cinemaRoomDetails) throws ResourceNotFoundException {
//        return null;
//    }
//
//    @Override
//    public void deleteCinemaRoom(int id) throws ResourceNotFoundException {
//
//    }
//
//    @Override
//    public List<Category> getAllCategories() {
//        return null;
//    }
//
//    @Override
//    public Category getCategoryById(int id) throws ResourceNotFoundException {
//        return null;
//    }
//
//    @Override
//    public Category addCategory(Category category) {
//        return null;
//    }
//
//    @Override
//    public Category updateCategory(int id, Category categoryDetails) throws ResourceNotFoundException {
//        return null;
//    }
//
//    @Override
//    public void deleteCategory(int id) throws ResourceNotFoundException {
//
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        return null;
//    }
//
//    @Override
//    public User getUserById(int id) throws ResourceNotFoundException {
//        return null;
//    }
//
//    @Override
//    public User addUser(User user) {
//        return null;
//    }
//
//    @Override
//    public User updateUser(int id, User userDetails) throws ResourceNotFoundException {
//        return null;
//    }
//
//    @Override
//    public void deleteUser(int id) throws ResourceNotFoundException {
//
//    }
//
//    @Override
//    public List<Reservation> getAllReservations() {
//        return reservationRepository.findAll();
//    }
//
//    @Override
//    public Reservation getReservationById(int id) throws ResourceNotFoundException {
//        return reservationRepository.findById((long) id).orElseThrow(() -> new ResourceNotFoundException("Reservation not found"));
//    }
//
//    @Override
//    public Reservation addReservation(Reservation reservation) {
//        return null;
//    }
//
//    @Override
//    public Reservation updateReservation(int id, Reservation reservationDetails) throws ResourceNotFoundException {
//        return null;
//    }
//
//    @Override
//    public Reservation createReservation(Reservation reservation) {
//        return reservationRepository.save(reservation);
//    }
//
//    @Override
//    public void deleteReservation(int id) throws ResourceNotFoundException {
//        Reservation reservation = getReservationById(id);
//        reservationRepository.delete(reservation);
//    }
//
//    @Override
//    public List<MessageComplaint> getAllMessageComplaints() {
//        return null;
//    }
//
//    @Override
//    public MessageComplaint getMessageComplaintById(int id) throws ResourceNotFoundException {
//        return null;
//    }
//
//    @Override
//    public MessageComplaint addMessageComplaint(MessageComplaint messageComplaint) {
//        return null;
//    }
//
//    @Override
//    public MessageComplaint updateMessageComplaint(int id, MessageComplaint messageComplaintDetails) throws ResourceNotFoundException {
//        return null;
//    }
//
//    @Override
//    public void deleteMessageComplaint(int id) throws ResourceNotFoundException {
//
//    }
//}
//
