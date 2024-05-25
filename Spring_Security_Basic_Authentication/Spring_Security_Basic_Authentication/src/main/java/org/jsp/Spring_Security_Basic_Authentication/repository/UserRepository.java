package org.jsp.Spring_Security_Basic_Authentication.repository;

import java.util.Optional;

import org.jsp.Spring_Security_Basic_Authentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String email);
}
