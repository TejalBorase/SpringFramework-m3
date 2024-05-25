package org.jsp.Spring_Security_Basic_Authentication.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "role_id")
	@SequenceGenerator(name="role_id", initialValue = 101, allocationSize = 1, 
					   sequenceName = "role_id_sequence")
	private int id;
	
	@Column(unique = true)
	private String role;
	
	@ManyToMany(mappedBy = "roles")
//	@JsonManagedReference
	private List<User> users;
}







