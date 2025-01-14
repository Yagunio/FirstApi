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
    private Long id;
    private String firstname;
    private String secondname;
    private String lastname;
    private Date birthday;
    private String address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;
}
