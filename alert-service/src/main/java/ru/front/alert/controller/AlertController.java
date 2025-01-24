package ru.front.alert.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.front.alert.model.Alert;
import ru.front.alert.model.ReactionType;
import ru.front.alert.service.AlertService;

import java.util.List;

@RestController
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

    @PutMapping("update_reaction/{alertId}/{reaction}")
    public String updateReaction(@PathVariable Long alertId, @PathVariable String reaction){
        if (reaction == null || !isValidReaction(reaction)) {
            return "Недопустимое значение reaction. Допустимые значения: Отказался, Принял, Ознакомлен";
        }
        alertService.setReaction(alertId, reaction);
        return "Реакция проставлена";
    }

    private boolean isValidReaction(String reaction) {
        for (ReactionType type : ReactionType.values()) {
            if (type.toString().equals(reaction.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}