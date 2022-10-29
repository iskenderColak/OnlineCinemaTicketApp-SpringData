package com.icolak;

import com.icolak.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    AccountRepository accountRepository;
    CinemaRepository cinemaRepository;
    GenreRepository genreRepository;
    MovieRepository movieRepository;
    MovieCinemaRepository movieCinemaRepository;
    TicketRepository ticketRepository;
    UserRepository userRepository;

    public QueryDemo(AccountRepository accountRepository, CinemaRepository cinemaRepository, GenreRepository genreRepository, MovieRepository movieRepository, MovieCinemaRepository movieCinemaRepository, TicketRepository ticketRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
        this.genreRepository = genreRepository;
        this.movieRepository = movieRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Hello");
        System.out.println("findByAgeLessThan: " + accountRepository.findByAgeLessThan(40));
        System.out.println("getCinemaByName: " + cinemaRepository.findByName("Hall 1 - EMPIRE"));

    }
}
