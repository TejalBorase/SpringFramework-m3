package com.jsp.REST_API.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jsp.REST_API.entity.Customer;
import com.jsp.REST_API.entity.Orders;
import com.jsp.REST_API.repository.CustomerRepository;
import com.jsp.REST_API.repository.OrdersRepository;
import com.jsp.REST_API.response.AppResponse;

import lombok.RequiredArgsConstructor;

@Component
//to generate constructor for final variables
@RequiredArgsConstructor
public class CustomerDao {

	//IoC inject dependency by calling constructor with argument
	private final CustomerRepository customerRepository;
	
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public List<Customer> fetchAllCustomer(){
		return customerRepository.findAll();
	}
	
	public Customer fetchCustomerById(int id) {
		return customerRepository.findById(id).orElse(null);
	}
	
	public void removeCustomerById(int id) {
		customerRepository.deleteById(id);
	}
	
	public Customer updateCustomerById(Customer customer, int id) {
		Customer customerFromDb = fetchCustomerById(id);
		if(customerFromDb != null) {
			customerFromDb.setName(customer.getName());
			return customerRepository.save(customerFromDb);
		}
		return null;
	}
	
	public List<Customer> getCustomerByName(String name){
		return customerRepository.findByName(name);
	}
	
}












