package org.jsp.Spring_MVC_Data_JPA.controller;

import java.util.List;

import org.jsp.Spring_MVC_Data_JPA.dao.DepartmentDao;
import org.jsp.Spring_MVC_Data_JPA.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/dept")
public class DepartmentController {

	@Autowired
	private DepartmentDao departmentDao;

	@RequestMapping("/saveDepartment")
	public String addDepartment(@RequestParam("deptName") String deptName, RedirectAttributes attributes) {
		Department dept = new Department();
		dept.setDepartmentName(deptName);
		// to save department data into db
		Department deptFromDb = departmentDao.addDepartment(dept);

		attributes.addFlashAttribute("msg",
				"Department has been added " + "successfully with id " + deptFromDb.getId());

		// redirect - url of another method
		return "redirect:page/1/id/ascending";
	}

	@RequestMapping("/viewDepartments")
	public String viewDepartments(Model model) {
		// fetch all department from db
		List<Department> departments = departmentDao.viewAllDepartments();
		model.addAttribute("listOfDepartments", departments);
		// return - html file
		return "View_Departments";
	}

	/**
	 * To transfer the data for redirect resource - RedirectAttributes interface
	 * contains addFlashAttribute("identifier", "data")
	 * 
	 * @param id
	 * @param attributes
	 * @return
	 */
	@RequestMapping("/removeDepartment/{id}")
	public String removeDepartment(@PathVariable("id") int id, RedirectAttributes attributes) {
		departmentDao.removeDepartmentById(id);

		attributes.addFlashAttribute("msg", "Department has been deleted successfully with id " + id);

		return "redirect:/dept/page/1/id/ascending";
	}

	@RequestMapping("/displayDept/{id}")
	public String displayDepartment(@PathVariable("id") int id, Model model) {

		Department department = departmentDao.getDepartmentById(id);

		model.addAttribute("dept", department);

		return "Update_Department";
	}

	@RequestMapping("/updateDepartment")
	public String updateDepartment(@ModelAttribute Department department, Model model, RedirectAttributes attributes) {
		Department dept = departmentDao.updateDepartment(department);
		if (dept != null) {
			attributes.addFlashAttribute("msg",
					"Department has been updated " + "successfully with id " + dept.getId());

			return "redirect:page/1/id/ascending";
		}
		model.addAttribute("msg", "Updation Unsuccessful!!!");
		return "Update_Department";
	}

	@RequestMapping("/page/{pageNum}/{columnName}/{direction}")
	public String listDepartmentByPage(@PathVariable("pageNum") int pageNum, 
									   Model model,
									   @PathVariable("columnName") String columnName,
									   @PathVariable("direction") String direction) {
		Page<Department> page = departmentDao.departmentListByPage(pageNum, columnName, direction);
		
		int pages = page.getTotalPages();
		model.addAttribute("noOfPage", pages);
		
		//to get list of page
		List<Department> content = page.getContent();
		
		model.addAttribute("listOfDepartments", content);
		model.addAttribute("columnName", columnName);
		model.addAttribute("direction", direction);
		
		model.addAttribute("pageNumber", pageNum);
		//reverse direction
		String reverseDirection = direction.equals("ascending") ? "descending" : "ascending";
		
		model.addAttribute("revDirection", reverseDirection);
		//transfer no. of pages
		return "View_Departments";
	}
}
