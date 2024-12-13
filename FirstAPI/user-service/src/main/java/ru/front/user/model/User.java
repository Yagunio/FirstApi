package ru.front.user.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Entity
@Table(name = "luser")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String secondName;
    @Column(unique = true)
    private String login;
    private String password;
    private Boolean isBlock;
    @ManyToOne
    private Role role;
}