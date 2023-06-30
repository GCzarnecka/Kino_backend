package com.kino.kino_backend.ICinemaInit;

import com.kino.kino_backend.Entities.*;
import com.kino.kino_backend.Repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
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
        Author author1 = new Author("Chad Stahelski", 54);
        Author author2 = new Author("Andrew Adamson", 56);
        Author author3 = new Author("Frank Darabont", 62);
        Author author4 = new Author("Francis Ford Coppola", 81);
        Author author5 = new Author("Christopher Nolan", 50);
        Author author6 = new Author("Peter Jackson", 59);
        Author author7 = new Author("Quentin Tarantino", 58);
        Author author8 = new Author("Alejandro G. Iñárritu", 58);
        Author author9 = new Author("Steven Spielberg", 74);
        List<Author> authors = new ArrayList<>(List.of(author1, author2, author3, author4, author5, author6, author7, author8, author9));
        authorRepository.saveAll(authors);
    }

    @Override
    public void initCategories() {
        Stream.of("Action", "Drama", "Comedy", "Fiction", "Crime", "Fantasy", "War","Western","Sci-Fi").forEach(category -> {
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
            cinemaRoom.setName(room);
            cinemaRoom.setRowsNumber(6);
            cinemaRoom.setColumnsNumber(10);

            cinemaRoomRepository.save(cinemaRoom);
        });

    }


    @Override
    public void initMovies() {
        movieRepository.save(new Movie(
                "John Wick",
                (Category) categorieRepository.findByName("Action"),
                2014,
                16,
                120,
                (Author) authorRepository.findByName("Chad Stahelski"),
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
                (Author) authorRepository.findByName("Andrew Adamson"),
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
                (Author) authorRepository.findByName("Frank Darabont"),
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
                (Author) authorRepository.findByName("Francis Ford Coppola"),
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
                (Author) authorRepository.findByName("Christopher Nolan"),
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
                (Author) authorRepository.findByName("Peter Jackson"),
                "https://images.moviesanywhere.com/45bc0ec075bfc0b4d8f184a7cc5bf993/876ed805-83b1-4387-b0d0-62d08c36536d.jpg",
                "The Lord of the Rings: The Return of the King is a 2003 epic fantasy adventure film directed by Peter Jackson," +
                        " based on the third volume of J. R. R. Tolkien's The Lord of the Rings. The film is the final instalment in the" +
                        " Lord of the Rings trilogy and was produced by Barrie M. Osborne, Jackson and Fran Walsh, and written by Walsh," +
                        " Philippa Boyens and Jackson. Continuing the plot of The Two Towers, Frodo, Sam and Gollum are making their final" +
                        " way toward Mount Doom in Mordor in order to destroy the One Ring, unaware of Gollum's true intentions, while" +
                        " Gandalf, Aragorn, Legolas, Gimli and the rest are joining forces together against Sauron and his legions in" +
                        " Minas Tirith."
        ));

        movieRepository.save(
                new Movie(
                        "The Lord of the Rings: The Fellowship of the Ring",
                        (Category) categorieRepository.findByName("Fantasy"),
                        2001,
                        12,
                        178,
                        (Author) authorRepository.findByName("Peter Jackson"),
                        "https://play-lh.googleusercontent.com/OkbZGHFUkGrqnPycygoqxbAJBE1WzR28vQbifQ-c5aNAapFl8F-eGeipwkweFVYYSMQQTcMvcDte_7HpwA=w240-h480-rw",
                        "The Lord of the Rings: The Fellowship of the Ring is a 2001 epic fantasy adventure film directed by Peter Jackson," +
                                " based on the first volume of J. R. R. Tolkien's The Lord of the Rings. The film is the first instalment in" +
                                " the Lord of the Rings trilogy and was produced by Barrie M. Osborne, Jackson, Fran Walsh and Tim Sanders," +
                                " and written by Walsh, Philippa Boyens and Jackson. The film features an ensemble cast including Elijah Wood," +
                                " Ian McKellen, Liv Tyler, Viggo Mortensen, Sean Astin, Cate Blanchett, John Rhys-Davies, Billy Boyd, Dominic" +
                                " Monaghan, Orlando Bloom, Christopher Lee, Hugo Weaving, Sean Bean, Ian Holm, and Andy Serkis. It was followed" +
                                " by The Two Towers (2002) and The Return of the King (2003)."
                )
        );

        movieRepository.save(new Movie(
                "The Lord of the Rings: The Two Towers",
                (Category) categorieRepository.findByName("Fantasy"),
                2002,
                12,
                179,
                (Author) authorRepository.findByName("Peter Jackson"),
"https://m.media-amazon.com/images/M/MV5BZGMxZTdjZmYtMmE2Ni00ZTdkLWI5NTgtNjlmMjBiNzU2MmI5XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_.jpg",
                "The Lord of the Rings: The Two Towers is a 2002 epic fantasy adventure film directed by Peter Jackson," +
                        " based on the second volume of J. R. R. Tolkien's The Lord of the Rings. The film is the second instalment" +
                        " in The Lord of the Rings trilogy and was produced by Barrie M. Osborne, Fran Walsh and Jackson, and written" +
                        " by Walsh, Philippa Boyens, Stephen Sinclair and Jackson. The film features an ensemble cast including Elijah" +
                        " Wood, Ian McKellen, Liv Tyler, Viggo Mortensen, Sean Astin, Cate Blanchett, John Rhys-Davies, Bernard Hill," +
                        " Christopher Lee, Billy Boyd, Dominic Monaghan, Orlando Bloom, Hugo Weaving, Miranda Otto, David Wenham," +
                        " Brad Dourif, Karl Urban and Andy Serkis. It was preceded by The Fellowship of the Ring (2001) and followed" +
                        " by The Return of the King (2003)."
        ));

        movieRepository.save(new Movie(
                "Django Unchained",
                (Category) categorieRepository.findByName("Western"),
                2012,
                18,
                165,
                (Author) authorRepository.findByName("Quentin Tarantino"),
"https://m.media-amazon.com/images/M/MV5BMjIyNTQ5NjQ1OV5BMl5BanBnXkFtZTcwODg1MDU4OA@@._V1_FMjpg_UX1000_.jpg",
                "Django Unchained is a 2012 American revisionist Western film written and directed by Quentin Tarantino," +
                        " starring Jamie Foxx, Christoph Waltz, Leonardo DiCaprio, Kerry Washington, and Samuel L. Jackson, with" +
                        " Walton Goggins, Dennis Christopher, James Remar, Michael Parks, and Don Johnson in supporting roles." +
                        " Set in the Old West and Antebellum South, it is a highly stylized variation of Spaghetti Westerns," +
                        " and a tribute to the 1966 Italian film Django by Sergio Corbucci, whose star Franco Nero has a cameo" +
                        " appearance. Development of Django Unchained began in 2007 when Tarantino was writing a book on" +
                        " Corbucci. By April 2011, Tarantino sent his final draft of the script to The Weinstein Company. Casting" +
                        " began in the summer of 2011, with Michael K. Williams and Will Smith being considered for the role of" +
                        " the title character before Foxx was cast. Principal photography took place from November 2011 to March" +
                        " 2012 in California, Wyoming and Louisiana."
        ));

        movieRepository.save(new Movie(
                "The Hateful Eight",
                (Category) categorieRepository.findByName("Western"),
                2015,
                18,
                187,
                (Author) authorRepository.findByName("Quentin Tarantino"),
"https://a.allegroimg.com/original/119d97/dc622bbb406491eea21acdf4a4b0/THE-HATEFUL-EIGHT-NIENAWISTNA-OSEMKA-DVD",
                "The Hateful Eight (often marketed as The H8ful Eight) is a 2015 American Western thriller film written" +
                        " and directed by Quentin Tarantino. It stars Samuel L. Jackson, Kurt Russell, Jennifer Jason Leigh," +
                        " Walton Goggins, Demián Bichir, Tim Roth, Michael Madsen, and Bruce Dern as eight strangers who seek" +
                        " refuge from a blizzard in a stagecoach stopover some time after the American Civil War. Tarantino" +
                        " announced the film in November 2013, stating it had originally started as a novel and sequel to" +
                        " Django Unchained. After the script leaked in January 2014, he cancelled the film but announced that" +
                        " he had changed his mind after directing a live reading of the script at the United Artists Theater" +
                        " in Los Angeles. Filming began on December 8, 2014, near Telluride, Colorado. The original score was" +
                        " composed by Ennio Morricone, his first complete Western score in 35 years. The film premiered on" +
                        " December 8, 2015, in 70 mm film format, before being released in digital theaters on December 25, 2015." +
                        " It grossed $155 million worldwide, received generally positive reviews from critics, and was" +
                        " nominated for three Academy Awards: Best Supporting Actress (Leigh), Best Original Score (Morricone)," +
                        " and Best Cinematography (Robert Richardson)."
        ));

        movieRepository.save(new Movie(
                "The Revenant",
                (Category) categorieRepository.findByName("Western"),
                2015,
                18,
                156,
                (Author) authorRepository.findByName("Alejandro G. Iñárritu"),
            "https://fwcdn.pl/fpo/65/83/586583/7722530.3.jpg",
                "The Revenant is a 2015 American epic Revisionist Western film directed by Alejandro González Iñárritu." +
                        " The screenplay by Mark L. Smith and Iñárritu is based in part on Michael Punke's 2002 novel of the" +
                        " same name, describing frontiersman Hugh Glass's experiences in 1823; that novel is, in turn, based" +
                        " on the 1915 poem The Song of Hugh Glass. The film stars Leonardo DiCaprio, Tom Hardy, Domhnall Gleeson," +
                        " and Will Poulter. Development began in August 2001 when Akiva Goldsman purchased Punke's manuscript" +
                        " with the intent to produce the film. The film was originally set to be directed by Park Chan-wook" +
                        " with Samuel L. Jackson in mind to star, and later by John Hillcoat with Christian Bale in negotiations" +
                        " to star. Both directors left the project, and Iñárritu signed on to direct in August 2011. In April" +
                        " 2014, after several delays in production due to other projects, Iñárritu confirmed that he was beginning" +
                        " work on The Revenant and that DiCaprio would play the lead role. It is the second on-screen collaboration" +
                        " among DiCaprio, Hardy, and Gleeson, following Inception, and the first time the latter two have starred" +
                        " together on-screen. Principal photography began in October 2014; delays associated with location and" +
                        " crew challenges resulted in the film's principal photography concluding in August 2015."
        ));

        movieRepository.save(
                new Movie(
                        "Inglourious Basterds",
                        (Category) categorieRepository.findByName("War"),
                        2009,
                        18,
                        153,
                        (Author) authorRepository.findByName("Quentin Tarantino"),
"https://m.media-amazon.com/images/I/817RLrtFSdL.jpg",
                        "Inglourious Basterds is a 2009 war film written and directed by Quentin Tarantino and starring Brad Pitt" +
                        " Christoph Waltz, Michael Fassbender, Eli Roth, Diane Kruger, Daniel Brühl, Til Schweiger and Mélanie Laurent"

                )
        )
        ;
        movieRepository.save(
                new Movie(
                        "Saving Private Ryan",
                        (Category) categorieRepository.findByName("War"),
                        1998,
                        18,
                        169,
                        (Author) authorRepository.findByName("Steven Spielberg"),
"https://m.media-amazon.com/images/M/MV5BZjhkMDM4MWItZTVjOC00ZDRhLThmYTAtM2I5NzBmNmNlMzI1XkEyXkFqcGdeQXVyNDYyMDk5MTU@._V1_FMjpg_UX1000_.jpg",
                        "Saving Private Ryan is a 1998 American epic war film directed by Steven Spielberg and written by Robert Rodat." +
                                " Set during the Invasion of Normandy in World War II, the film is notable for its graphic portrayal of war," +
                                " and for the intensity of its opening 27 minutes, which includes a depiction of the Omaha Beach assault" +
                                " during the Normandy landings. It follows United States Army Rangers Captain John H. Miller (Tom Hanks)" +
                                " and a squad (Tom Sizemore, Edward Burns, Barry Pepper, Giovanni Ribisi, Vin Diesel, Adam Goldberg, and" +
                                " Jeremy Davies) as they search for a paratrooper, Private First Class James Francis Ryan (Matt Damon)," +
                                " who is the last-surviving brother of four servicemen."
                )
        )
        ;

//        movieRepository.save(new Movie(
//                "The Hateful Eight",
//                (Category) categorieRepository.findByName("Western"),
//                2015,
//                18,
//                187,
//                (Author) authorRepository.findByName("Quentin Tarantino"),
//                "https://images.moviesanywhere.com/45bc0ec075bfc0b4d8f184a7cc5bf993/876ed805-83b1-4387-b0d0-62d08c36536d.jpg",
//                "The Hateful Eight (often marketed as The H8ful Eight) is a 2015 American Western film written and directed by" +
//                        " Quentin Tarantino. It stars Samuel L. Jackson, Kurt Russell, Jennifer Jason Leigh, Walton Goggins, Demián" +
//                        " Bichir, Tim Roth, Michael Madsen, and Bruce Dern as eight strangers who seek refuge from a blizzard in a" +
//                        " stagecoach stopover some time after the American Civil War. Tarantino announced the film in November 2013," +
//                        " stating it had originally started as a novel and sequel to Django Unchained. After the script leaked in" +
//                        " January 2014, he cancelled the film but announced that he had changed his mind after directing a live" +
//                        " reading of the script at the United Artists Theater in Los Angeles. Filming began on December 8, 2014," +
//                        " near Telluride, Colorado. The original score was composed by Ennio Morricone, his first complete Western" +
//                        " score in 35 years. The film premiered on December 8, 2015, in 70 mm film format, before being released" +
//                        " in digital theaters on December 25, 2015. It grossed $155 million worldwide, received generally positive" +
//                        " reviews from critics, and was nominated for three Academy Awards: Best Supporting Actress (Leigh), Best" +
//                        " Original Score (Morricone), and Best Cinematography (Robert Richardson)."
//        ));

        movieRepository.save(
                new Movie(
                        "Interstellar",
                        (Category) categorieRepository.findByName("Sci-Fi"),
                        2014,
                        12,
                        169,
                        (Author) authorRepository.findByName("Christopher Nolan"),
"https://m.media-amazon.com/images/I/61pyUElLh7L._AC_UF1000,1000_QL80_.jpg",
                        "Intrerstellar is a 2014 epic science fiction film directed and produced by Christopher Nolan. It stars Matthew" +
                                " McConaughey, Anne Hathaway, Jessica Chastain, Bill Irwin, Ellen Burstyn, and Michael Caine. Set in a" +
                                " dystopian future where humanity is struggling to survive, the film follows a group of astronauts who" +
                                " travel through a wormhole near Saturn in search of a new home for humanity."
                ));
        movieRepository.save(
                new Movie(
                        "Inception",
                        (Category) categorieRepository.findByName("Sci-Fi"),
                        2010,
                        12,
                        148,
                        (Author) authorRepository.findByName("Christopher Nolan"),
"https://fwcdn.pl/fpo/08/91/500891/7354571.3.jpg",
                        "Inception is a 2010 science fiction action film[4][5][6] written and directed by Christopher Nolan, who also" +
                                " produced the film with his wife, Emma Thomas. The film stars Leonardo DiCaprio as a professional thief" +
                                " who steals information by infiltrating the subconscious of his targets. He is offered a chance to have" +
                                " his criminal history erased as payment for the implantation of another person's idea into a target's" +
                                " subconscious. The ensemble cast includes Ken Watanabe, Joseph Gordon-Levitt, Marion Cotillard, Ellen" +
                                " Page, Tom Hardy, Dileep Rao, Cillian Murphy, Tom Berenger, and Michael Caine."
                ));
        movieRepository.save(
                new Movie(
                        "Infinity War",
                        (Category) categorieRepository.findByName("Sci-Fi"),
                        2018,
                        12,
                        149,
                        (Author) authorRepository.findByName("Anthony Russo"),
                        "https://static.posters.cz/image/1300/plakaty/avengers-infinity-war-one-sheet-i122134.jpg",
                        "Avengers: Infinity War is a 2018 American superhero film based on the Marvel Comics superhero team the Avengers," +
                                " produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures. It is the sequel to" +
                                " 2012's The Avengers and 2015's Avengers: Age of Ultron, and the nineteenth film in the Marvel Cinematic" +
                                " Universe (MCU). It was directed by Anthony and Joe Russo, written by Christopher Markus and Stephen" +
                                " McFeely, and features an ensemble cast including Robert Downey Jr., Chris Hemsworth, Mark Ruffalo," +
                                " Chris Evans, Scarlett Johansson, Benedict Cumberbatch, Don Cheadle, Tom Holland, Chadwick Boseman," +
                                " Paul Bettany, Elizabeth Olsen, Anthony Mackie, Sebastian Stan, Danai Gurira, Letitia Wright," +
                                " Dave Bautista, Zoe Saldana, Josh Brolin, and Chris Pratt. In the film, the Avengers and the Guardians" +
                                " of the Galaxy attempt to stop Thanos from collecting the six all-powerful Infinity Stones as part of" +
                                " his quest to kill half of all life in the universe."
                ));
        movieRepository.save(
                new Movie(
                        "Joker",
                        (Category) categorieRepository.findByName("Drama"),
                        2019,
                        15,
                        122,
                        (Author) authorRepository.findByName("Todd Phillips"),
"https://fwcdn.pl/fpo/01/67/810167/7905225.3.jpg",
                        "Joker is a 2019 American psychological thriller film directed and produced by Todd Phillips, who co-wrote the" +
                                " screenplay with Scott Silver. The film, based on DC Comics characters, stars Joaquin Phoenix as the Joker." +
                                " An origin story set in 1981, the film follows Arthur Fleck, a failed stand-up comedian who turns to a life" +
                                " of crime and chaos in Gotham City. Robert De Niro, Zazie Beetz, Frances Conroy, Brett Cullen, Glenn" +
                                " Fleshler, Bill Camp, Shea Whigham, and Marc Maron appear in supporting roles. Joker was produced by" +
                                " Warner Bros. Pictures, DC Films, and Joint Effort, in association with Bron Creative and Village Roadshow" +
                                " Pictures, and distributed by Warner Bros."
                )
                );

    }

    @Override
    public void initReservations() {
//        reservationRepository.save(new Reservation(){});
    }


    @Override
    public void initScreenings() {
        CinemaRoom cr = cinemaRoomRepository.findByName("Room 1");
        for(Movie m : movieRepository.findAll()){

                for(int days = 0; days < 7; days++)
                {

                    for( int hour = 0; hour < 5; hour++)
                    {
                        // get random number between 1 and 59
                        int minute = ThreadLocalRandom.current().nextInt(0, 59 + 1);

                        //get random number between 10 and 15
                        int hourStart = ThreadLocalRandom.current().nextInt(10, 15 + 1);
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
                        screening.setStartDateTime(LocalDateTime.now().plusDays(days).withHour(hourStart + hour).withMinute(minute));
                        screeningRepository.save(screening);
                    }

                }
        }
    }

    @Override
    public void initSeats() {
//        Seat seat = new Seat();
//        seatRepository.save();
    }

    @Override
    public void initUsers() {

        User user = new User();
        user.setName("Admin");
        user.setSurname("Admin");
        user.setEmail("admin@admin.pl");
        user.setPassword("$2a$10$QndQWVzW0STfCZw023HhqOXPtC18asjeZ5eSQMgZzzcd2p95TmWMC");
        user.setAge(18);
        user.setRole(Role.ADMIN);
        userRepository.save(user);
    }
}
