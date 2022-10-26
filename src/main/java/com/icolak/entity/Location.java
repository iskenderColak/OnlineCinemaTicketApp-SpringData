package com.icolak.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Data
public class Location extends BaseEntity{
    private String name;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String address;
    private String postalCode;
    private String country;
    private String state;
    private String city;
}
