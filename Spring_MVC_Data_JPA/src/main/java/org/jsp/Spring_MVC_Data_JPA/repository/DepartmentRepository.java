package org.jsp.Spring_MVC_Data_JPA.repository;

import org.jsp.Spring_MVC_Data_JPA.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
