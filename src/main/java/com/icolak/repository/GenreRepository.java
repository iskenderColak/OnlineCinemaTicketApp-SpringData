package com.icolak.repository;

import com.icolak.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that return all genres
    @Query("Select g from Genre g")
    List<Genre> fetchAllGenre();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns genres by containing name
    @Query(value = "select * from genre where name ilike concat('%', ?1, '%')", nativeQuery = true)
    List<Genre> retrieveByName(@Param("name") String name);

}
