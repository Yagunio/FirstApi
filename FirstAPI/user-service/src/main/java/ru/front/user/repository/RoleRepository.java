package ru.front.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.front.user.model.Role;
import ru.front.user.model.User;

public interface RoleRepository extends JpaRepository<Role, Long> {
    void deleteByName(String name);

    User findByName(String name);

}
