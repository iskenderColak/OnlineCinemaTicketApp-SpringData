package com.icolak.repository;

import com.icolak.entity.Movie;
import com.icolak.enums.MovieState;
import com.icolak.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
    Optional<Movie> findByName(String name);

    //Write a derived query to list all movies between a range of prices
    List<Movie> findAllByPriceBetween(BigDecimal p1, BigDecimal p2);

    //Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie> findAllByDurationIn(List<Integer> duration);

    //Write a derived query to list all movies with higher than a specific release date
    List<Movie> findAllByReleaseDateAfter(LocalDate date);

    //Write a derived query to list all movies with a specific state and type
    List<Movie> findAllByStateAndType(MovieState state, MovieType type);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
    @Query("select m from Movie m where m.price between ?1 and ?2")
    List<Movie> fetchMovieBetweenPriceRange(@Param("p1") BigDecimal p1, @Param("p2") BigDecimal p2);


    //Write a JPQL query that returns all movie names
    @Query("select distinct m.name from Movie m")
    List<String> fetchAllMovieNames();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name
    @Query(value = "select * from movie where name = ?1 ", nativeQuery = true)
    List<Movie> fetchMovieByName(@Param("name") String name); // it may be optional instead of List

    //Write a native query that return the list of movies in a specific range of prices
    @Query(value = "select * from movie where price between ?1 and ?2", nativeQuery = true)
    List<Movie> fetchMoviesPricesBetween(@Param("p1") BigDecimal p1, @Param("p2") BigDecimal p2);

    //Write a native query to return all movies where duration exists in the range of duration
    @Query(value = "select * from movie where duration between ?1 and ?2", nativeQuery = true)
    List<Movie> fetchMoviesdurationBetweenRange(@Param("d1") Integer d1, @Param("d2") Integer d2);
    //@Query(value = "select * from movie where duration in ?1", nativeQuery = true)
    //List<Movie> fetchMoviesdurationBetweenRange(@Param("d1") List<Integer> d1);
    //Write a native query to list the top 5 most expensive movies
    @Query(value = "select * from movie order by price limit 5", nativeQuery = true)
    List<Movie> topFiveMovie();
}
