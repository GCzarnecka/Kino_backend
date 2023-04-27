package com.kino.kino_backend.ICinemaInit;

import com.kino.kino_backend.Entities.*;
import com.kino.kino_backend.Repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
@Transactional
public class CinemaInit implements ICinemaInit{

    @Autowired
    private CategoryRepository categorieRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CinemaRoomRepository cinemaRoomRepository;

    @Autowired
    private MessageComplaintRepository messageComplaintRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ScreeningRepository screeningRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private UserRepository userRepository;



    @Override
    public void initAuthors() {
        Stream.of("Author 1", "Author 2", "Author 3", "Author 4", "Author 5").forEach(author -> {
            Author author1 = new Author();
            author1.setName(author);
            author1.setSurname("Surname");
            author1.setAge(20);
            authorRepository.save(author1);
        });
    }

    @Override
    public void initCategories() {
        Stream.of("Action", "Drama", "Comedy", "Fiction", "Crime").forEach(category -> {
            Category categorie = new Category();
            categorie.setName(category);
            categorie.setDescription("This is a description for " + category);
            categorieRepository.save(categorie);
        });
    }

    @Override
    public void initCinemaRooms() {
        Stream.of("Room 1", "Room 2", "Room 3", "Room 4", "Room 5").forEach(room -> {
            CinemaRoom cinemaRoom = new CinemaRoom();
            cinemaRoom.setName(room);
            List<Seat> seats = new ArrayList<>();
            for(int i =0;i<10;i++){
                for(int j =0;j<10;j++){
                    Seat seat = new Seat();
                    seat.setSectorNumber(i);
                    seat.setSeatNumber(j);
//                    seat.setCinemaRoom(cinemaRoom);
                    seatRepository.save(seat);
                    seats.add(seat);
                }
            }
            cinemaRoom.setSeats(seats);
            cinemaRoom.setName(room);
            cinemaRoom.setRowsNumber(10);
            cinemaRoom.setColumnsNumber(10);

//            cinemaRoom.setScreenings();


            cinemaRoomRepository.save(cinemaRoom);
        });

    }

    @Override
    public void initMessageComplaints() {


        messageComplaintRepository.save(new MessageComplaint(){});
    }

    @Override
    public void initMovies() {
        movieRepository.save(new Movie(){});

    }

    @Override
    public void initReservations() {
        reservationRepository.save(new Reservation(){});
    }

    @Override
    public void initScreenings() {
        List<Screening> screenings =  new ArrayList<>();
        for(int i =0;i<10;i++){
            Screening screening = new Screening();
            screening.setMovie(movieRepository.findById(1L).get());
            screening.setCinemaRoom(cinemaRoomRepository.findById(1L).get());
            screening.setStartDateTime(LocalDateTime.parse("2021-06-01 12:00"));
//            screening.setScreeningTime("12:00");
            screening.setCinemaRoom(cinemaRoomRepository.findById(1L).get());
            screening.setMovie(movieRepository.findById(1L).get());

            screeningRepository.save(screening);
            screenings.add(screening);
        }
    }

    @Override
    public void initSeats() {
//        Seat seat = new Seat();
//        seatRepository.save();
    }

    @Override
    public void initUsers() {
        Stream.of("User 1", "User 2", "User 3", "User 4", "User 5").forEach(user -> {
            User user1 = new User();
            user1.setName(user);
            user1.setSurname("Surname");
            user1.setAge(20);
            userRepository.save(user1);
        });
    }
}
