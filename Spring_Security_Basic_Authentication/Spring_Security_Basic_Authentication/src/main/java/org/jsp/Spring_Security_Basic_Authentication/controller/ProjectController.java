package org.jsp.Spring_Security_Basic_Authentication.controller;

import java.util.List;

import org.jsp.Spring_Security_Basic_Authentication.dao.ProjectDao;
import org.jsp.Spring_Security_Basic_Authentication.entity.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class ProjectController {

	private final ProjectDao dao;
	
	@PostMapping("/projects")
	public ResponseEntity<Project> addProject(@RequestBody Project project){
		Project projectFromDb = dao.addProject(project);
		return ResponseEntity.ok().body(projectFromDb);
	}
	
	@GetMapping("/hii")
	public String sample() {
		return "Hii";
	}
	
	@GetMapping("/projects")
	public ResponseEntity<List<Project>> viewProject(){
		return ResponseEntity.ok().body(dao.viewProject());
	}
}









