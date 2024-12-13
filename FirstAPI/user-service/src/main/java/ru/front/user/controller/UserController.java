package ru.front.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.front.user.model.User;
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

    @PostMapping("save_user")
    public User saveUser(@RequestBody User user){

        return userService.saveUser(user);
    }

    @GetMapping("/{login}")
    public User findByLogin(@PathVariable String login){
        return userService.findByLogin(login);
    }

    @PutMapping("update_user")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("delete_user/{login}")
    public void deleteUser(@PathVariable String login){
        userService.deleteUser(login);
    }
}
