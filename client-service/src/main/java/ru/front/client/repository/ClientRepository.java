package ru.front.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.front.client.model.Client;
import ru.front.client.model.Passport;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    void deleteById(Long id);

    List<Client> findByLastname(String lastname);

    Client findByPassport(Passport passport);
}
