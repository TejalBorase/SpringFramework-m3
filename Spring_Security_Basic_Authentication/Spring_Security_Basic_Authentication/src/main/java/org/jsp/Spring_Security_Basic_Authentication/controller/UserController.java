package org.jsp.Spring_Security_Basic_Authentication.controller;

import java.util.List;

import org.jsp.Spring_Security_Basic_Authentication.dao.RoleDao;
import org.jsp.Spring_Security_Basic_Authentication.dao.UserDao;
import org.jsp.Spring_Security_Basic_Authentication.dto.UserDto;
import org.jsp.Spring_Security_Basic_Authentication.entity.Role;
import org.jsp.Spring_Security_Basic_Authentication.entity.User;
import org.jsp.Spring_Security_Basic_Authentication.repository.RoleRepository;
import org.jsp.Spring_Security_Basic_Authentication.repository.UserRepository;
import org.jsp.Spring_Security_Basic_Authentication.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
	
	private final RoleDao roleDao;
	private final UserDao userDao;

	@PostMapping("/roles")
	public ResponseEntity<Role> addRole(@RequestBody Role role){
		return ResponseEntity.ok(roleDao.addRole(role));
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody User user){
		return ResponseEntity.ok(userDao.addUser(user));
	}
	
	@PutMapping("/users/{id}/roles/{role}")
	public ResponseEntity<User> updateRole(@PathVariable("role") String role,
										   @PathVariable("id") int userId){
		
		
		return ResponseEntity.ok(userDao.updateRole(userId, role));
	}
	
	private final UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> fetchAllUsers(){
		return ResponseEntity.ok(userService.fetchAllUser());
	}
}





