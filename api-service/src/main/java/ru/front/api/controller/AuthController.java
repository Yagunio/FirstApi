package ru.front.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.front.api.service.UserService;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    UserService userService;

    @PostMapping("/login")
    public String login(String login){
        return "Авторизация прошла успешно";
    }
}
