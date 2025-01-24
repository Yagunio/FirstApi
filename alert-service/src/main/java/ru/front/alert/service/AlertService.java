package ru.front.alert.service;

import org.springframework.stereotype.Service;
import ru.front.alert.model.Alert;

import java.util.List;

@Service
public interface AlertService {
    List<Alert> findAllAlert();

    List<Alert> findByClientId(Long clientId);

    List<Alert> findByClientIdAndNotReaction(Long clientId);

    Alert saveAlert(Alert alert);


}
