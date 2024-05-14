package org.jsp.Spring_Security_Basic_Authentication.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
//Customize configuration in spring boot
@Configuration
public class SecurityConfiguration {
	
	//Customize authentication & authorization
	/**
	 * SecurityFilterChain interface
	 * HttpSecurity class - provides methods to customization
	 * call authorizeHttpRequest(return type is HttpSecurity) method with argument - to customize authorization
	 * It takes argument as a Customizer function interface - customize method
	 * Provide argument as AuthorizeHttpRequestsConfigurer class ref var
	 * call anyRequest method from AHRC - return AuthorizedUrl
	 * use this - authenticated all the request
	 * @param httpSecurity
	 * @return
	 */
	@Bean
	public SecurityFilterChain getFilterChain(HttpSecurity httpSecurity) throws Exception{
		//to authenticated each request
		//hii - allow only for trainer
		//projects - allow only for student
		httpSecurity.authorizeHttpRequests((authorization) ->
			authorization
				.requestMatchers("/v1/hii")
				.hasRole("TRAINER")
				.requestMatchers("/v1/projects")
				.hasRole("STUDENT")
				.anyRequest()
				.authenticated()
		)
		.httpBasic(Customizer.withDefaults());
		//to build configuration
		return httpSecurity.build();
	}
	
	//modified username & password
	/**
	 * InMemoryUserDetailsManager - class - store customize username & password
	 * in memory
	 * UserDetails is interface - to provide new username and password
	 * User is class - used to specify username & password
	 * withDefaultPasswordEncoder() method - encodes password internally(deprecated)
	 * Other methods needs explicit PasswordEncoder
	 * Without password encoder - we can't perform authentication
	 */
	@Bean
	public InMemoryUserDetailsManager userDetails() {
		//to specify username & password
		UserDetails Student = User.withUsername("root")
								  .password(this.encodePassword().encode("sql123"))
								  .roles("STUDENT")
								  .build();
		UserDetails Trainer = User.withUsername("trainer")
								  .password(this.encodePassword().encode("12345"))
								  .roles("TRAINER")
								  .build();
		return new InMemoryUserDetailsManager(Student, Trainer);
	}
	//to create passwordEncoder
	/**
	 * PasswordEncoder is an Interface contains encode() method
	 * BCryptPasswordEncoder is a class - used to encode password by using
	 * BCrypt mechanism - internally uses - Hashing mechanism
	 * @return
	 */
	@Bean
	public PasswordEncoder encodePassword() {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		return bcrypt;
	}
	
	
	
	
	
	
	
	
	
	
	
}








