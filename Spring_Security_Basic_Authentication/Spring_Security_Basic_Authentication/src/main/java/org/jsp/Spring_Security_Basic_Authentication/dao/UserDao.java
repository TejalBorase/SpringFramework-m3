package org.jsp.Spring_Security_Basic_Authentication.dao;

import java.util.ArrayList;
import java.util.List;

import org.jsp.Spring_Security_Basic_Authentication.entity.Role;
import org.jsp.Spring_Security_Basic_Authentication.entity.User;
import org.jsp.Spring_Security_Basic_Authentication.repository.RoleRepository;
import org.jsp.Spring_Security_Basic_Authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserDao {

	private final UserRepository userRepository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User addUser(User user) {
		//before saving password - encode password
		String password = user.getPassword();
		String encodedPassword = passwordEncoder.encode(password);
		user.setPassword(encodedPassword);
		//user.setPassword(passwordEncoder.encode(user.getPassword)));
		return userRepository.save(user);
	}
	
	private final RoleRepository roleRepository;
	
	public User updateRole(int id, String role) {
		User user = userRepository.findById(id).orElse(null);
		if(user != null) {
			System.out.println(user);
			Role roleFromDb = roleRepository.findByRole(role).orElse(null);
			System.out.println(roleFromDb);
			if(roleFromDb != null) {
				List<Role> roles = new ArrayList<Role>(List.of(roleFromDb));
				user.setRoles(roles);
				System.out.println(roles);
				User updated = userRepository.save(user);
				System.out.println(updated);
				return updated;
			}
			return null;
		}
		return null;
	}
	
	public List<User> fetchAllUser(){
		return userRepository.findAll();
	}
}









