package ru.front.alert.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.front.alert.model.Alert;
import ru.front.alert.repository.AlertRepository;
import ru.front.alert.service.AlertService;

import java.util.List;

@Service
@AllArgsConstructor
public class AlertServiceImpl implements AlertService {

    private AlertRepository alertRepository;

    @Override
    public List<Alert> findAllAlert() {
        return alertRepository.findAll();
    }

    @Override
    public List<Alert> findByClientId(Long clientId) {
        return alertRepository.findByClientId(clientId);
    }

    @Override
    public List<Alert> findByClientIdAndNotReaction(Long clientId) {
        List<Alert> alertList = alertRepository.findByClientId(clientId);
        return alertList.stream().
                filter(x -> x.getReaction() == null).
                toList();
    }

    @Override
    public Alert saveAlert(Alert alert) {
        return alertRepository.save(alert);
    }
}
