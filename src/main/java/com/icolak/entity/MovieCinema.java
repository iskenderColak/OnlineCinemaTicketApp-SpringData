package com.icolak.entity;

import java.time.LocalDateTime;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class MovieCinema extends BaseEntity{

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cinema cinema;
}
