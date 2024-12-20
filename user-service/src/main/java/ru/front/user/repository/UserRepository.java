package ru.front.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.front.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    void deleteByLogin(String login);

    User findByLogin(String login);
}
