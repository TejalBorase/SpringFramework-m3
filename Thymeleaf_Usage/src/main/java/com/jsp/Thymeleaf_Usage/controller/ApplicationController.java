package com.jsp.Thymeleaf_Usage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsp.Thymeleaf_Usage.model.User;

@Controller
@RequestMapping("/app")
public class ApplicationController {

	//localhost:8080/app/demo1
	@RequestMapping("/demo1")
	public String displayDemo1(Model model) {
		model.addAttribute("a1", 10);
		return "Demo1";
	}
	
	@RequestMapping("/demo2")
	public String displayObjectData(Model model) {
		User user = new User();
		user.setId(1);
		user.setName("ABC");
		model.addAttribute("userInfo", user);
		return "Demo1";
	}
	
	@RequestMapping("/demo3")
	public String displayListElement(Model model) {
		List<String> names = new ArrayList<String>();
		names.add("PQR");
		names.add("XYZ");
		model.addAttribute("studentNames", names);
		return "Demo1";
	}
	
	@RequestMapping("/demo4")
	public String displayListObject(Model model) {
		List<User> users = new ArrayList<User>();
		User user1 = new User();
		user1.setId(101);
		user1.setName("Raja");
		
		User user2 = new User();
		user2.setId(102);
		user2.setName("Rani");
		
		users.add(user2);
		users.add(user1);
		
		System.out.println(users);
		model.addAttribute("usersObject", users);
		return "Demo1";
	}
}










