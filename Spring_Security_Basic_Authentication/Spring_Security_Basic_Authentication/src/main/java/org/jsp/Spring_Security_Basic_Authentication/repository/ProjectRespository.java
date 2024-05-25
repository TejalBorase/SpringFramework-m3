package org.jsp.Spring_Security_Basic_Authentication.repository;

import org.jsp.Spring_Security_Basic_Authentication.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRespository extends JpaRepository<Project, Integer>{

}
