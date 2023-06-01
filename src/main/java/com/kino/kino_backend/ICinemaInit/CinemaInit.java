package com.kino.kino_backend.ICinemaInit;

import com.kino.kino_backend.Entities.*;
import com.kino.kino_backend.Repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

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
        Stream.of("Action", "Drama", "Comedy", "Fiction", "Crime", "Fantasy").forEach(category -> {
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
//            List<Seat> seats = new ArrayList<>();
//            for(int i =0;i<10;i++){
//                for(int j =0;j<10;j++){
//                    Seat seat = new Seat();
//                    seat.setSectorNumber(i);
//                    seat.setSeatNumber(j);
//                    seatRepository.save(seat);
//                    seats.add(seat);
//                }
//             }
//           cinemaRoom.setSeats(seats);
            cinemaRoom.setName(room);
            cinemaRoom.setRowsNumber(6);
            cinemaRoom.setColumnsNumber(10);

//            cinemaRoom.setScreenings();


            cinemaRoomRepository.save(cinemaRoom);
        });

    }

//    @Override
//    public void initMessageComplaints() {
//
//    }

    @Override
    public void initMovies() {
        movieRepository.save(new Movie(
                "John Wick",
                (Category) categorieRepository.findByName("Action"),
                2014,
                16,
                120,
                (Author) authorRepository.findByName("Author 1"),
                "https://upload.wikimedia.org/wikipedia/en/9/98/John_Wick_TeaserPoster.jpg",
                "John Wick is a 2014 American neo-noir action-thriller film directed by Chad Stahelski, " +
                        "in his directorial debut, and written by Derek Kolstad. It stars Keanu Reeves, " +
                        "Michael Nyqvist, Alfie Allen, Adrianne Palicki, Bridget Moynahan, Dean Winters, Ian McShane," +
                        " John Leguizamo, and Willem Dafoe. It is the first installment in the John Wick film series."

        ));

        movieRepository.save(new Movie(
                "Shrek",
                (Category) categorieRepository.findByName("Comedy"),
                2001,
                7,
                90,
                (Author) authorRepository.findByName("Author 2"),
                "https://a.allegroimg.com/original/1173c0/c7054d4a4416a3c75f92f9f9043f/SHREK-FOREVER-DVD",
                "Shrek is a 2001 American computer-animated comedy film " +
                        "loosely based on the 1990 fairy tale picture book of the same " +
                        "name by William Steig. Directed by Andrew Adamson and Vicky Jenson " +
                        "in their directorial debuts, it stars Mike Myers, Eddie Murphy," +
                        " Cameron Diaz and John Lithgow as the voices of the lead characters. " +
                        "The film parodies other films adapted from fairy tale storylines, " +
                        "primarily aimed at animated Disney films. In the story, " +
                        "an ogre called Shrek (Myers) finds his swamp overrun by" +
                        " fairy tale creatures who have been banished by the corrupt " +
                        "Lord Farquaad (Lithgow) aspiring to be king. Shrek makes a " +
                        "deal with Farquaad to regain control of his swamp in return" +
                        " for rescuing Princess Fiona (Diaz), whom he intends to marry. " +
                        "With the help of Donkey (Murphy), Shrek embarks on his quest but " +
                        "soon falls in love with the princess, who is hiding a secret that" +
                        " will change his life forever."
        ));

        movieRepository.save(new Movie(
                "The Shawshank Redemption",
                (Category) categorieRepository.findByName("Drama"),
                1994,
                16,
                142,
                (Author) authorRepository.findByName("Author 3"),
                "https://upload.wikimedia.org/wikipedia/en/8/81/ShawshankRedemptionMoviePoster.jpg",
                "The Shawshank Redemption is a 1994 American drama film written and directed by Frank Darabont," +
                        " based on the 1982 Stephen King novella Rita Hayworth and Shawshank Redemption. It tells the story" +
                        " of banker Andy Dufresne (Tim Robbins), who is sentenced to life in Shawshank State Penitentiary for" +
                        " the murders of his wife and her lover, despite his claims of innocence. Over the following two decades," +
                        " he befriends a fellow prisoner, contraband smuggler Ellis \"Red\" Redding (Morgan Freeman), and becomes" +
                        " instrumental in a money-laundering operation led by the prison warden Samuel Norton (Bob Gunton). " +
                        "William Sadler, Clancy Brown, Gil Bellows, and James Whitmore appear in supporting roles."
        ));

        movieRepository.save(new Movie(
                "The Godfather",
                (Category) categorieRepository.findByName("Crime"),
                1972,
                16,
                175,
                (Author) authorRepository.findByName("Author 4"),
                "https://upload.wikimedia.org/wikipedia/en/1/1c/Godfather_ver1.jpg",
                "The Godfather is a 1972 American crime film directed by Francis Ford Coppola, " +
                        "who co-wrote the screenplay with Mario Puzo, based on Puzo's best-selling 1969 novel of the same name." +
                        " The film stars Marlon Brando, Al Pacino, James Caan, Richard Castellano, Robert Duvall, Sterling Hayden," +
                        " John Marley, Richard Conte, and Diane Keaton. It is the first installment in The Godfather trilogy." +
                        " The story, spanning from 1945 to 1955, chronicles the Corleone family under patriarch Vito Corleone (Brando)," +
                        " focusing on the transformation of one of his sons, Michael Corleone (Pacino), from reluctant family outsider" +
                        " to ruthless mafia boss."
        ));

        movieRepository.save(new Movie(
                "The Dark Knight",
                (Category) categorieRepository.findByName("Action"),
                2008,
                16,
                152,
                (Author) authorRepository.findByName("Author 5"),
                "https://m.media-amazon.com/images/I/91KkWf50SoL._AC_UF1000,1000_QL80_.jpg",
                "The Dark Knight is a 2008 superhero film directed, produced, and co-written by Christopher Nolan." +
                        " Based on the DC Comics character Batman, the film is the second installment of Nolan's The Dark Knight Trilogy" +
                        " and a sequel to 2005's Batman Begins, starring Christian Bale and supported by Michael Caine, Heath Ledger," +
                        " Gary Oldman, Aaron Eckhart, Maggie Gyllenhaal, and Morgan Freeman. In the film, Bruce Wayne / Batman (Bale)," +
                        " Police Lieutenant James Gordon (Oldman) and District Attorney Harvey Dent (Eckhart) form an alliance to dismantle" +
                        " organized crime in Gotham City, but are menaced by an anarchistic mastermind known as the Joker (Ledger)," +
                        " who seeks to undermine Batman's influence and turn the city to chaos."
        ));

        movieRepository.save(new Movie(
                "The Lord of the Rings: The Return of the King",
                (Category) categorieRepository.findByName("Fantasy"),
                2003,
                12,
                201,
                (Author) authorRepository.findByName("Author 6"),
                "https://images.moviesanywhere.com/45bc0ec075bfc0b4d8f184a7cc5bf993/876ed805-83b1-4387-b0d0-62d08c36536d.jpg",
                "The Lord of the Rings: The Return of the King is a 2003 epic fantasy adventure film directed by Peter Jackson," +
                        " based on the third volume of J. R. R. Tolkien's The Lord of the Rings. The film is the final instalment in the" +
                        " Lord of the Rings trilogy and was produced by Barrie M. Osborne, Jackson and Fran Walsh, and written by Walsh," +
                        " Philippa Boyens and Jackson. Continuing the plot of The Two Towers, Frodo, Sam and Gollum are making their final" +
                        " way toward Mount Doom in Mordor in order to destroy the One Ring, unaware of Gollum's true intentions, while" +
                        " Gandalf, Aragorn, Legolas, Gimli and the rest are joining forces together against Sauron and his legions in" +
                        " Minas Tirith."
        ));

    }

    @Override
    public void initReservations() {
//        reservationRepository.save(new Reservation(){});
    }

    private static LocalDateTime getRandomLocalDateTime(){
        long minDay = LocalDateTime.of(2020, Month.DECEMBER, 1, 0, 0).toEpochSecond(ZoneOffset.UTC);
        long maxDay = LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59).toEpochSecond(ZoneOffset.UTC);
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDateTime.ofEpochSecond(randomDay, 0, ZoneOffset.UTC);
    }

    @Override
    public void initScreenings() {
        CinemaRoom cr = cinemaRoomRepository.findByName("Room 1");
        for(Movie m : movieRepository.findAll()){

            ArrayList<Seat> seats = new ArrayList<>();

            for(int i = 0; i < cr.getRowsNumber(); i++)
                for(int j = 0; j < cr.getColumnsNumber(); j++) {
                    var seat = new Seat(i, j, false);
                    seats.add(seat);
                    seatRepository.save(seat);
                }

                Screening screening = new Screening();
                screening.setMovie(m);
                screening.setCinemaRoom(cr);
                screening.setSeats(seats);
                screening.setStartDateTime(LocalDateTime.parse("2023-06-03T12:00:00"));
                screeningRepository.save(screening);
        }
    }

    @Override
    public void initSeats() {
//        Seat seat = new Seat();
//        seatRepository.save();
    }

    @Override
    public void initUsers() {
//        User user1 = new User();
//        user1.setName("Gosia");
//        user1.setSurname("Jakas");
//        user1.setEmail("gosia@mail.pl");
//        user1.setPassword("1234");
//        user1.setAge(18);
//        userRepository.save(user1);
//
//        User user2 = new User();
//        user2.setName("Konrad");
//        user2.setSurname("Jakis");
//        user2.setEmail("konrad@mail.pl");
//        user2.setPassword("1234");
//        user2.setAge(18);
//        user2.setAdmin(true);
//        userRepository.save(user2);
    }
}
