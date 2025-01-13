package ru.front.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.front.client.model.Passport;

public interface PassportRepository extends JpaRepository<Passport, Long> {

    Passport findBySerialAndNumber(String serial, String number);
}
