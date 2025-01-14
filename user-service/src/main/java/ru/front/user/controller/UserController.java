package ru.front.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.front.user.model.Role;
import ru.front.user.model.User;
import ru.front.user.model.UserDto;
import ru.front.user.service.RoleService;
import ru.front.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping
    public List<User> findAllUser(){
        return userService.findAllUser();
    };

    @GetMapping("/{login}")
    public UserDto findByLogin(@PathVariable String login){
        User user = userService.findByLogin(login);
        if (user.getIsBlock()){
            return null;
        }
        return userService.convertToUserDto(user);
    }

    @PostMapping("save_user")
    public String saveUser(@RequestBody User user){
        userService.saveUser(user);
        return "Пользователь добавлен";
    }

    @PutMapping("update_user")
    public String updateUser(@RequestBody User user){
        userService.updateUser(user);
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
