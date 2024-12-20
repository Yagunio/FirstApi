package ru.front.user.service;

import ru.front.user.model.Role;
import ru.front.user.model.User;

import java.util.List;

public interface RoleService {
    public List<Role> findAllRole();
    public Role findByName(String name);
    public Role saveRole(Role role);
    public Role updateRole(Role role);

    public void deleteRole(String login);
}
