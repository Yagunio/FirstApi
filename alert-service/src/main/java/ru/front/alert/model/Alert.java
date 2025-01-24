package ru.front.alert.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Alert {
    @Id
    @GeneratedValue
    private Long id;

    private Long clientId;
    private String text;
    //@Enumerated(EnumType.STRING)
    //private ReactionType reaction;
    private String reaction;
}
