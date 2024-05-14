package com.jsp.REST_API.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.REST_API.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	List<Customer> findByName(String name);
}
