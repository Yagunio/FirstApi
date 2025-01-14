package ru.front.user.service;

import org.springframework.stereotype.Service;
import ru.front.user.model.User;
import ru.front.user.model.UserDto;

import java.util.List;

@Service
public interface UserService {
    public List<User> findAllUser();
    public User findByLogin(String login);
    public User saveUser(User user);
    public User updateUser(User user);

    public void deleteUser(String login);

    public String changeBlockUser(String login);

    public UserDto convertToUserDto(User user);
}
