package ru.front.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.front.user.model.Role;
import ru.front.user.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@AllArgsConstructor
public class RoleController {
    private RoleService roleService;

    @GetMapping
    public List<Role> findAllRole() {return roleService.findAllRole();};

    @PostMapping("save_role")
    public String saveRole(@RequestBody Role role) {
        Role roleNow = roleService.saveRole(role);
        return "Роль добавлена";
    }
    @PutMapping("update_role")
    public String updateRole(@RequestBody Role role) {
        Role roleNow = roleService.updateRole(role);
        return "Роль обновлена";
    }

    @DeleteMapping("delete_role/{name}")
    public String deleteRole(@PathVariable String name) {
        roleService.deleteRole(name);
        return "Роль далена";
    }
}
