package ru.front.product.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.front.product.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

    @Value("${client.service.url}")
    private String clientServiceUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public String getClientById(Long clientId) {
        String url = clientServiceUrl + "/" + clientId;
        return restTemplate.getForObject(url, String.class);
    }
}
