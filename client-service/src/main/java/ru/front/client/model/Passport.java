package ru.front.client.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "passport")
public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    private String serial;

    private String number;
}
