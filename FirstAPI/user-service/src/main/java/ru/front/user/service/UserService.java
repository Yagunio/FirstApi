package ru.front.user.service;

import org.springframework.stereotype.Service;
import ru.front.user.model.User;

import java.util.List;

@Service
public interface UserService {
    public List<User> findAllUser();
    public User findByLogin(String login);
    public User saveUser(User user);
    public User updateUser(User user);

    public void deleteUser(String login);
}
