package ru.front.user.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.front.user.model.Role;
import ru.front.user.repository.RoleRepository;
import ru.front.user.repository.UserRepository;
import ru.front.user.service.RoleService;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;
    @Override
    public List<Role> findAllRole() {
        return repository.findAll();
    }

    @Override
    public Role findByName(String name) {
        return null;
    }

    @Override
    public Role saveRole(Role role) {
        return repository.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        return null;
    }

    @Override
    public void deleteRole(String login) {

    }
}
