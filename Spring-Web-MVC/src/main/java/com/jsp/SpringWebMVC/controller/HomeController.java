package com.jsp.SpringWebMVC.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
//to store data into session
@SessionAttributes("sampleData")
public class HomeController {

	// To transfer data from controller to view (jsp file)
	// Model interface
	// to transfer data - addAttibute("identifier", data)
	@RequestMapping("/data")
	public String transferData(Model model) {
		model.addAttribute("name", "Qwerty");
		model.addAttribute("number", 34);

		// to method return view name
		return "Demo";
	}

	// localhost:8080/home/test1
	@RequestMapping("/test1")
	public ModelAndView transferDataByModelAndView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Test");
		// to transfer data
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(10);
		numbers.add(20);
		mv.addObject("list", numbers);

		return mv;
	}

	// localhost:8084/home/path/20
	@RequestMapping("/path/{number}")
	public void usageOfPathVariable(@PathVariable("number") int num) {
		System.out.println("Number = " + num);
	}

	// localhost:8084/home/path/20/rani
	@RequestMapping("/path/{number}/{name}")
	public void usageOfPathVariable2(@PathVariable("number") int num, @PathVariable("name") String name) {
		System.out.println("Number = " + num);
		System.out.println("Name = " + name);
	}

	@RequestMapping("/demo")
	public void demo() {
		System.out.print("This is demo method");
	}
	
	//localhost:8080/home/redirectDemo
	@RequestMapping("/redirectDemo")
	public String redirectToDemo() {
		System.out.println("This redirectMethod...");
		System.out.println("Operation has been completed...");
		return "redirect:demo";
	}
	//localhost:8080/home/facebook
	@RequestMapping("/facebook")
	public String displayFacebook() {
		return "redirect:http://www.facebook.com";
	}
	
	
	@RequestMapping("/sessionObj")
	public ModelAndView storeDataIntoSession() {
		//to add data into session
		ModelAndView mv = new ModelAndView();
		mv.addObject("sampleData", "Spring Boot");
		mv.setViewName("session");
		return mv;
	}
	
	@RequestMapping("/accessData")
	@ResponseBody
	public String accessDataFromSession(HttpSession session) {
		String msg = (String)session.getAttribute("sampleData");
		System.out.println(msg);
		return msg;
	}

}











