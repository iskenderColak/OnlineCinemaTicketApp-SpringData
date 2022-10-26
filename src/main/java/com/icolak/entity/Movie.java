package com.icolak.entity;

import com.icolak.enums.MovieState;
import com.icolak.enums.MovieType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Movie extends BaseEntity{

    private Integer duration;
    private String name;
    private BigDecimal price;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime releaseDate;
    @Enumerated(EnumType.STRING)
    private MovieState state;
    @Column(columnDefinition = "text")
    private String summary;
    @Enumerated(EnumType.STRING)
    private MovieType type;

    @ManyToMany
    @JoinTable(name = "movie_genre_rel",
    joinColumns = @JoinColumn(name = "movie_id"),
    inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genre;

}
