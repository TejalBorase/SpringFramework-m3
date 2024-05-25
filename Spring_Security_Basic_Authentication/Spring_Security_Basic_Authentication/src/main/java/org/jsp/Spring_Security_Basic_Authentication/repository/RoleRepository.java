package org.jsp.Spring_Security_Basic_Authentication.repository;

import java.util.Optional;

import org.jsp.Spring_Security_Basic_Authentication.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	Optional<Role> findByRole(String role);
}
