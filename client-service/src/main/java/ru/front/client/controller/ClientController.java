package ru.front.client.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.front.client.model.Client;
import ru.front.client.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;

    @GetMapping
    public List<Client> findAllClient(){
        return clientService.findAllClient();
    }

    @GetMapping("/{lastname}")
    public List<Client> findClientByLastname(@PathVariable String lastname){
        return clientService.findClientByLastname(lastname);
    }

    @GetMapping("/{serial}/{number}")
    public Client findClientByPassportSerialAndNumber(@PathVariable String serial, @PathVariable String number) {
        return clientService.findClientByPassportSerialAndNumber(serial, number);
    }

    @PostMapping("save_client")
    public String saveClient(@RequestBody Client client) {
        clientService.saveClient(client);
        return "Клиент добавлен";
    }

    @PutMapping("update_client")
    public String updateClient(@RequestBody Client client) {
        clientService.updateClient(client);
        return "Клиент обновлен";
    }

    @DeleteMapping("delete_client/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return "Клиент удален";
    }
}
