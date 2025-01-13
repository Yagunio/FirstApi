package ru.front.client.service;

import org.springframework.stereotype.Service;
import ru.front.client.model.Client;
import ru.front.client.model.Passport;

import java.util.List;
@Service
public interface ClientService {
    public List<Client> findAllClient();

    public List<Client> findClientByLastname(String lastname);

    public Client findClientByPassportSerialAndNumber(String serial, String number);

    public Client saveClient(Client client);

    public Client updateClient(Client client);

    public void deleteClient(Long id);
}
