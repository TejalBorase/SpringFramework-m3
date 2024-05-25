package org.jsp.Spring_Security_Basic_Authentication.securityConfig;

import org.jsp.Spring_Security_Basic_Authentication.entity.User;
import org.jsp.Spring_Security_Basic_Authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ProductUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//call findByEmail method to get user object from db
		User user = userRepository.findByEmail(username).orElse(null);
		if(user != null) {
			System.out.println(user);
			ProductUserDetails details = new ProductUserDetails(user);
			return details;
		}
		return null;
	}

}





