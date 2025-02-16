package ru.front.api.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.front.api.model.UserDetailsDTO;
import ru.front.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Value("${user.service.url}")
    private String userServiceUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public UserDetails getUserByLogin(String login) throws UsernameNotFoundException{
        String url = userServiceUrl + "/" + login;
        UserDetailsDTO userDetails = restTemplate.getForObject(url, ru.front.api.model.UserDetailsDTO.class);

        if (userDetails == null) {
            throw new UsernameNotFoundException("Пользователь не найден: " + login);
        }
        return userDetails;
    }
}