package ru.front.user.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class UserDto {
    private String fio;
    private String login;
    private RoleDto role;
}