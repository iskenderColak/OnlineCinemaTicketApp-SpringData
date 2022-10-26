package com.icolak.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Cinema extends BaseEntity {

    private String name;
    private String sponsoredName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;

}
