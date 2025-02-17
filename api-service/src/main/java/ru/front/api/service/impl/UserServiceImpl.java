package ru.front.api.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.front.api.model.UserDetailsDTO;
import ru.front.api.service.UserService;

import java.io.IOException;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Value("${user.service.url}")
    private String userServiceUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String url = userServiceUrl + "/" + username;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if (response.getStatusCode() != HttpStatus.OK || response.getBody() == null) {
            throw new UsernameNotFoundException("Пользователь не найден: " + username);
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(response.getBody());
            UserDetailsDTO userDetails = new UserDetailsDTO();
            userDetails.setUsername(root.path("login").asText());
            userDetails.setPassword(root.path("password").asText());
            return userDetails;
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при преобразовании JSON", e);
        }
    }
}