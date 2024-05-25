package org.jsp.Spring_Security_Basic_Authentication.dao;

import org.jsp.Spring_Security_Basic_Authentication.entity.Role;
import org.jsp.Spring_Security_Basic_Authentication.repository.RoleRepository;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RoleDao {

	private final RoleRepository roleRepository;
	
	public Role addRole(Role role) {
		return roleRepository.save(role);
	}
}
