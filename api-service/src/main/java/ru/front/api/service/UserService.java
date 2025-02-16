package ru.front.api.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public String getUserByLogin(String login);
}
