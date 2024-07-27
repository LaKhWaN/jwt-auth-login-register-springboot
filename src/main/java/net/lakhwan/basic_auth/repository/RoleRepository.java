package net.lakhwan.basic_auth.repository;

import net.lakhwan.basic_auth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
