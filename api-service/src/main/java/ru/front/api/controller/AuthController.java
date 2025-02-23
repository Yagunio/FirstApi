package ru.front.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.front.api.service.UserService;

@RestController
@RequestMapping("api/v1/auth")
@AllArgsConstructor
public class AuthController {
    UserService userService;

    @GetMapping("/login/{login}")
    public UserDetails login(@PathVariable String login){
        return userService.loadUserByUsername(login);
    }
}