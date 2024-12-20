package ru.front.user.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.front.user.model.User;
import ru.front.user.repository.RoleRepository;
import ru.front.user.repository.UserRepository;
import ru.front.user.service.RoleService;
import ru.front.user.service.UserService;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private RoleRepository roleRepository;

    @Override
    public List<User> findAllUser() {
        return repository.findAll();
    }

    @Override
    public User findByLogin(String login) {
        return repository.findByLogin(login);
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return repository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(String login) {
        repository.deleteByLogin(login);
    }

    @Override
    public String changeBlockUser(String login) {
        User userNow = findByLogin(login);
        userNow.setIsBlock(!userNow.getIsBlock());
        updateUser(userNow);
        return "Пользователь " + login + ((userNow.getIsBlock()) ? " заблокирован" : " разблокирован");
    }
}
