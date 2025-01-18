package ru.front.product.service;

import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    public String getClientById(Long clientId);
}
