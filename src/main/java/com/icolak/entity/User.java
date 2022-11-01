package com.icolak.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_account")
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity{

    private String email;
    private String password;
    private String username;

    @OneToOne
    @JoinColumn(name = "account_details_id")
    private Account account;

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

}
