package org.jsp.Spring_MVC_Data_JPA.dao;

import java.util.List;

import org.jsp.Spring_MVC_Data_JPA.entity.Department;
import org.springframework.data.domain.Page;

public interface DepartmentDao {

	Department addDepartment(Department department);
	
	List<Department> viewAllDepartments();
	
	void removeDepartmentById(int id);
	
	Department getDepartmentById(int id);
	
	Department updateDepartment(Department department);
	
	Page<Department> departmentListByPage(int pageNum, String columnName, String direction);
}







