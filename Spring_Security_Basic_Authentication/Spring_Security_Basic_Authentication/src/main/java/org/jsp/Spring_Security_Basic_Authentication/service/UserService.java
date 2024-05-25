package org.jsp.Spring_Security_Basic_Authentication.service;

import java.util.List;

import org.jsp.Spring_Security_Basic_Authentication.dao.UserDao;
import org.jsp.Spring_Security_Basic_Authentication.dto.UserDto;
import org.jsp.Spring_Security_Basic_Authentication.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
	
	public List<UserDto> fetchAllUser() {
		List<User> users = dao.fetchAllUser();
		// to convert list of entities to list of dto
		List<UserDto> userDtos = users.stream().map((user) -> {
			
//			UserDto dto = new UserDto();
//			dto.setEmail(user.getEmail());
//			dto.setId(user.getUserId());
//			dto.setUsername(user.getFullName());
//			return dto;
			UserDto dto = UserDto.builder()
								 .email(user.getEmail())
								 .id(user.getUserId())
								 .username(user.getFullName())
								 .build();
			return dto;
		}).toList();
		return userDtos;
	}
}
