package org.jsp.Spring_Security_Basic_Authentication.dao;

import java.util.List;

import org.jsp.Spring_Security_Basic_Authentication.entity.Project;
import org.jsp.Spring_Security_Basic_Authentication.repository.ProjectRespository;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProjectDao {

	private final ProjectRespository respository;
	
	public Project addProject(Project project) {
		return respository.save(project);
	}
	
	public List<Project> viewProject(){
		return respository.findAll();
	}
}










