package org.jsp.Spring_MVC_Data_JPA.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.Spring_MVC_Data_JPA.entity.Department;
import org.jsp.Spring_MVC_Data_JPA.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class DepartmentDaoImpl implements DepartmentDao{

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department addDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> viewAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public void removeDepartmentById(int id) {
		departmentRepository.deleteById(id);
	}

	@Override
	public Department getDepartmentById(int id) {
		Optional<Department> optional= departmentRepository.findById(id);
		Department dept = optional.orElse(null);
		return dept;
	}

	@Override
	public Department updateDepartment(Department department) {
		//find
		Department dept = getDepartmentById(department.getId()); 
		if(dept != null) {
			//update
			dept.setDepartmentName(department.getDepartmentName());
			Department updatedObject = departmentRepository.save(dept);
			return updatedObject;
		}
		return null;
	}
	
	//constant variable - because page size is fixed
	private static final int PAGE_SIZE = 3;

	@Override
	public Page<Department> departmentListByPage(int pageNum, 
												 String columnName, 
												 String direction) {
		//because user enters page number from 1
		int pageNumber = pageNum - 1;
		
		//sort records by columnName
		Sort sort = Sort.by(columnName);
		//sort records by direction
		sort = direction.equals("ascending") ? sort.ascending() : sort.descending();
		
		//Divides records into the pages after sorting
		Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE, sort);
		
		Page<Department> page = departmentRepository.findAll(pageable);
		System.out.println("No. of Total pages = " + page.getTotalPages());	
		return page;
	}

	

}






