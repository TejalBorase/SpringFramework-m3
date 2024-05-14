package com.jsp.SpringWebMVC.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/assignment")
public class AssignmentController {

	@RequestMapping("/showSample")
	public String showSamplePage() {
		return "Sample";
	}
	
	@RequestMapping("/remove")
	public String removeDuplicate(@RequestParam("string") String data,
								  Model model) {
		String output = withoutDuplicates(data);
		model.addAttribute("original", data);
		model.addAttribute("duplicatesRemove", output);
		
		return "Display";
	}
	
	public String withoutDuplicates(String string) {
		String finalOutput = "";
		for (int i = 0; i < string.length(); i++) {
			if(finalOutput.indexOf(string.charAt(i)) == -1) {
				finalOutput += string.charAt(i);
			}
		}
		return finalOutput;
	}
	
	@RequestMapping("/addProduct")
	public String showAddProductPage() {
		return "AddProduct";
	}
	
	List<Product> products = new ArrayList<Product>();
	
	@RequestMapping("/showProduct")
	public ModelAndView addProduct(@ModelAttribute Product product) {
		//add product to list
		products.add(product);
		System.out.println("List of Product" + products);
		//transfer data
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ShowProduct");
		mv.addObject("productObj", product);
		mv.addObject("message", "Product Added....");
		mv.addObject("listOfProduct", products);
		
		return mv;
	}
	
	@RequestMapping("/deleteProduct/{productId}")
	public String deleteRecord(@PathVariable("productId") int id) {
		Iterator<Product> itr = products.iterator();
		while (itr.hasNext()) {
			if(itr.next().getId() == id) {
				itr.remove();
			}
		}
		System.out.println(products);
		return "redirect:displayProduct";
	}
	
	@RequestMapping("/displayProduct")
	public String displayProducts(Model model) {
		model.addAttribute("listOfProduct", products);
		return "ShowProduct";
	}
	
	
}



















