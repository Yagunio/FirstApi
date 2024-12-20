package ru.front.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.front.user.model.Role;
import ru.front.user.model.User;
import ru.front.user.service.RoleService;
import ru.front.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    private RoleService roleService;

    @GetMapping
    public List<User> findAllUser(){
        return userService.findAllUser();
    };

    @GetMapping("/{login}")
    public User findByLogin(@PathVariable String login){
        return userService.findByLogin(login);
    }

    @PostMapping("save_user")
    public String saveUser(@RequestBody User user){
        Role role = user.getRole();
        if (role == null)
            return "Укажите роль пользователя";
        String roleName = role.getName();
        if (roleName.isEmpty())
            return "Укажите наименование роли пользователя";

        user.setRole(roleService.findByName(roleName));
        User userNow = userService.saveUser(user);
        return "Пользователь добавлен";
    }

    @PutMapping("update_user")
    public String updateUser(@RequestBody User user){
        Role role = user.getRole();
        if (role == null)
            return "Укажите роль пользователя";
        String roleName = role.getName();
        if (roleName.isEmpty())
            return "Укажите наименование роли пользователя";

        user.setRole(roleService.findByName(roleName));
        User userNow = userService.updateUser(user);
        return "Пользователь обновлен";
    }

    @PutMapping("block_user/{login}")
    public String blockUser(@PathVariable String login){
        return userService.changeBlockUser(login);
    }

    @DeleteMapping("delete_user/{login}")
    public String deleteUser(@PathVariable String login){
        userService.deleteUser(login);
        return "Пользователь удален";
    }
}
