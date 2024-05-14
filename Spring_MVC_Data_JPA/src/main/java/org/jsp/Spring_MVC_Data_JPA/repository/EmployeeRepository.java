package org.jsp.Spring_MVC_Data_JPA.repository;

import org.jsp.Spring_MVC_Data_JPA.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
