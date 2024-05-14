package com.jsp.SpringWebMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 1. to represent controller / Spring class
 * 2. act like @Component 
 * 3. IoC container(WebApplicationContext) will create object of resp class
 */
@Controller
@RequestMapping("/app")
public class AppController {

	@RequestMapping("/run")
	public void run() {
		System.out.println("This is run method executed...");
	}
	
	//to fetch data from url
	//search url = localhost:8080/app/fetch?data1=20
	@RequestMapping("/fetch")
	public void fetchData(@RequestParam("data1") int number) {
		System.out.println("Number = " + number);
	}
	
	//search url = localhost:8080/app/test?age=34&name=qwerty
	@RequestMapping("/test")
	public void fetchMultipleData(@RequestParam("age") int age, 
								  @RequestParam("name") String name) {
		System.out.println("Age = " + age);
		System.out.println("Name = " + name);
	}
	
	//localhost:8080/app/user?id=1&fn=Qwerty&ln=XYZ&email=qwerty@gmail.com&mobile=1234567890
	@RequestMapping("/user")
	public void fetchUserDetails(@RequestParam("id") int userId, 
								 @RequestParam("fn") String firstName,
								 @RequestParam("ln")String lastName, 
								 @RequestParam("email") String email, 
								 @RequestParam("mobile") long mobile) {
		
		System.out.println(userId);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(email);
		System.out.println(mobile);
	}
	
	//localhost:8080/app/userInfo?userId=1&firstName=Qwerty&lastName=XYZ&email=qwerty@gmail.com&mobile=1234567890
	/**
	 * for multiple query parameter - @ModelAttibute
	 * 1. Need to create Model class, consists variables to represent
	 * each query parameter keys.
	 * 2. While searching url - keys should be same as variable name of model
	 * 3. Create a Model class along with variables & getter setter
	 * 4. IoC container performs following operation for @ModelAttribute
	 * 		a. create object of Model class.
	 * 		b. map keys of parameter with variable of model class
	 * 		c. if both are same, then it will call setters to inject data 
	 * 		   in variables.
	 * 	    d. finally, store object into resp. ref. var.
	 */
	@RequestMapping("/userInfo")
	public void fetchUser(@ModelAttribute User user) {
		System.out.println(user);
	}
	
	//localhost:8081/app/add?n1=10&n2=20
	@RequestMapping("/add")
	//to provide response on browser
	@ResponseBody
	public String displayOutput(@RequestParam("n1") int num1, 
								@RequestParam("n2") int num2) {
		return num1 + " + " + num2 + " = " + (num1 + num2);
	}
	
	//localhost:8080/app/fetchUser?userId=1&firstName=Qwerty&lastName=XYZ&email=qwerty@gmail.com&mobile=1234567890
	@RequestMapping("/fetchUser")
	@ResponseBody
	public User displayUserData(@ModelAttribute User user) {
		return user;
	}
	
	//localhost:8080/app/index
	@RequestMapping("/index")
	//@ResponseBody - print text on webpage
	public String showIndexPage() {
		// (/) to represent webapp folder
		//return "/index.jsp";
		return "index";
	}
	//localhost:8083/app/showDemo
	@RequestMapping("/showDemo")
	public String showDemoPage() {
		//extension & path added by ViewTemplate
		return "Demo";
	}
}

















