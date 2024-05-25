package org.jsp.Spring_Security_Basic_Authentication.securityConfig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jsp.Spring_Security_Basic_Authentication.entity.Role;
import org.jsp.Spring_Security_Basic_Authentication.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ProductUserDetails implements UserDetails{
	
	private User user;
	
	public ProductUserDetails(User user) {
		System.out.println("sample");
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("roles");
		List<Role> roles = user.getRoles();
		List<SimpleGrantedAuthority> authorities = 
				new ArrayList<SimpleGrantedAuthority>();
		for (Role role : roles) {
			System.out.println(role.getRole());
			SimpleGrantedAuthority authority = 
					new SimpleGrantedAuthority(role.getRole());
			authorities.add(authority);
		}
		
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
