package ru.front.alert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.front.alert.model.Alert;

import java.util.List;

public interface AlertRepository extends JpaRepository<Alert, Long> {
    List<Alert> findAll();

    List<Alert> findByClientId(Long clientId);

    Alert findAlertById(Long id);
}
