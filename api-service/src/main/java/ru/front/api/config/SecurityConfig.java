package ru.front.api.config;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import ru.front.api.model.UserDetailsDTO;
import ru.front.api.service.UserService;

@Configuration
@EnableWebSecurity
@Data
public class SecurityConfig {

    private final UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll() // Разрешаем доступ к эндпоинтам авторизации
                        .anyRequest().authenticated() // Все остальные запросы требуют авторизации
                )
                .userDetailsService(userService)
                .httpBasic(Customizer.withDefaults()); // Используем базовую аутентификацию
        return http.build();
    }
}
