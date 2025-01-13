package ru.front.client.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue
    Long id;

    String firstname;

    String secondname;

    String lastname;

    Date birthday;

    String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    Passport passport;
}
