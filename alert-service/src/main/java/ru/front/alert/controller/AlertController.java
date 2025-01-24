package ru.front.alert.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.front.alert.model.Alert;
import ru.front.alert.service.AlertService;

import java.util.List;

@Controller
@RequestMapping("api/v1/alerts")
@AllArgsConstructor
public class AlertController {
    private AlertService alertService;

    @GetMapping
    public List<Alert> findAllAlert() {
        return alertService.findAllAlert();
    };

    @GetMapping("/client/all/{clientId}")
    public List<Alert> findByClientId(@PathVariable  Long clientId){
        return alertService.findByClientId(clientId);
    };

    @GetMapping("/client/new/{clientId}")
    public List<Alert> findByClientIdAndNotReaction(@PathVariable Long clientId){
        return alertService.findByClientIdAndNotReaction(clientId);
    };

    @PostMapping("save_alert")
    public String saveAlert(@RequestBody Alert alert){
        alertService.saveAlert(alert);
        return "Клиентское предложение сохранено";
    };
}
