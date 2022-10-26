package com.icolak.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Genre extends BaseEntity {

    private String name;

}
