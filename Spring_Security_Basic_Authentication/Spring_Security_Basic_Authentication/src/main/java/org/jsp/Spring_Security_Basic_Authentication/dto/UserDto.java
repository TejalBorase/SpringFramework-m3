package org.jsp.Spring_Security_Basic_Authentication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//to provide the of necessary data to an user
public class UserDto {

	private int id;
	private String username;
	private String email;
}
