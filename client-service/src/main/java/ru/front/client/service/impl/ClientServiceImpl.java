package ru.front.client.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.front.client.model.Client;
import ru.front.client.repository.ClientRepository;
import ru.front.client.repository.PassportRepository;
import ru.front.client.service.ClientService;

import java.util.List;
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private PassportRepository passportRepository;

    @Override
    public List<Client> findAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> findClientByLastname(String lastname) {
        return clientRepository.findByLastname(lastname);
    }

    @Override
    public Client findClientByPassportSerialAndNumber(String serial, String number) {
        return clientRepository.findByPassport(passportRepository.findBySerialAndNumber(serial, number));
    }
    @Override
    @Transactional
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }
    @Override
    @Transactional
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
