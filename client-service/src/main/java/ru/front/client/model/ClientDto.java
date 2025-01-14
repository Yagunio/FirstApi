package ru.front.client.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;
@Data
public class ClientDto {
    private String fio;
    private String birthday;
    private PassportDto passport;
    private String address;
}
