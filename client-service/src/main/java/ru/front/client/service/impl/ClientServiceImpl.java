package ru.front.client.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.front.client.model.Client;
import ru.front.client.model.ClientDto;
import ru.front.client.model.PassportDto;
import ru.front.client.repository.ClientRepository;
import ru.front.client.repository.PassportRepository;
import ru.front.client.service.ClientService;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    public ClientDto convertToClientDto(Client client) {
        ClientDto clientDto = new ClientDto();

        // Формируем ФИО
        String fio = client.getLastname() + " " + client.getFirstname() + " " + client.getSecondname();
        clientDto.setFio(fio);

        // Форматируем дату рождения
        Date birthday = client.getBirthday();
        if (birthday != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String birthDay = dateFormat.format(birthday);
            clientDto.setBirthday(birthDay);
        }

        // Преобразуем паспорт
        PassportDto passportDto = new PassportDto();
        passportDto.setSerial(client.getPassport().getSerial());
        passportDto.setNumber(client.getPassport().getNumber());
        clientDto.setPassport(passportDto);

        // Устанавливаем адрес
        clientDto.setAddress(client.getAddress());

        return clientDto;
    }
}
