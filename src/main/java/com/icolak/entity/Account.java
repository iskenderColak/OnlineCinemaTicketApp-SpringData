package com.icolak.entity;

import com.icolak.enums.UserRole;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "account_details")
@NoArgsConstructor
@Data
public class Account extends BaseEntity {

    private String address;
    private Integer age;
    private String city;
    private String country;
    private String name;
    private String postal_code;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private String state;

    @OneToOne(mappedBy = "account")
    private User user;
}
