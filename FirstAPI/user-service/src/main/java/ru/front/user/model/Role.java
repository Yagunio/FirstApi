package ru.front.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private String description;
}
