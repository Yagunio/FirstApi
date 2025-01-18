package ru.front.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class ClientProduct {
    @Id
    @GeneratedValue
    private Long id;
    private Long clientId;
    private Long productId;
}
