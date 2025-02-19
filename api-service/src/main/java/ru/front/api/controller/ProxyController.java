package ru.front.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/proxy")
@AllArgsConstructor
public class ProxyController {
    private RestTemplate restTemplate;
    private final String urlUsers = "http://localhost:8080/api/v1/users";
    private final String urlClients = "http://localhost:8081/api/v1/clients";
    private final String urlProducts = "http://localhost:8082/api/v1/products";
    private final String urlAlerts = "http://localhost:8083/api/v1/alerts";

    @GetMapping("/users/{proxy}")
    public ResponseEntity<String> proxyToUserService(@PathVariable String proxy) {
        String url = urlUsers + proxy;
        return restTemplate.getForEntity(url, String.class);
    }

    @GetMapping("/clients/{proxy}")
    public ResponseEntity<String> proxyToClientService(@PathVariable String proxy) {
        String url = urlClients + proxy;
        return restTemplate.getForEntity(url, String.class);
    }

    @GetMapping("/products/{proxy}")
    public ResponseEntity<String> proxyToProductService(@PathVariable String proxy) {
        String url = urlProducts + proxy;
        return restTemplate.getForEntity(url, String.class);
    }

    @GetMapping("/alerts/{proxy}")
    public ResponseEntity<String> proxyToAlertService(@PathVariable String proxy) {
        String url = urlAlerts + proxy;
        return restTemplate.getForEntity(url, String.class);
    }
}
