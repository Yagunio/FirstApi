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

    String firstName;

    String secondName;

    String lastName;

    Date birthday;

    String address;

    @OneToOne
    @JoinColumn(name = "passport_id")
    Passport passport;

    @Transient
    private String fullName;

    public String getFullName(){
        return lastName + ' ' + firstName + ' ' + secondName;
    }
}
