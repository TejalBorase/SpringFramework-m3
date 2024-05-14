package com.jsp.REST_API.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.REST_API.dao.CustomerDao;
import com.jsp.REST_API.dao.OrdersDao;
import com.jsp.REST_API.entity.Customer;
import com.jsp.REST_API.entity.Orders;
import com.jsp.REST_API.response.AppResponse;

import lombok.RequiredArgsConstructor;

//rest api's
@RestController
@RequiredArgsConstructor
@RequestMapping("/resource1")
public class CustomerController {

	@GetMapping("/firstapi")
	public ResponseEntity<String> firstapi() {
//		ResponseEntity<String> re = ResponseEntity.ok("This is dummy api....");
//		return re;
//		return ResponseEntity.ok("This is dummy api....");
//		BodyBuilder status = ResponseEntity.status(HttpStatus.CREATED);
		return ResponseEntity.status(HttpStatus.CREATED).body("Resource created");
	}
	
	private final CustomerDao dao;
	
	//create api - to create customer resource
	//@RequestBody is used to take data in the form JSON
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
//		return dao.addCustomer(customer);
		Customer dataInserted = dao.addCustomer(customer);
		ResponseEntity<Customer> response = 
				new ResponseEntity(dataInserted, HttpStatus.CREATED);
		return response;
	}
	
	//create api - to fetch all customer resource
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> fetchAllCustomer(){
//		return dao.fetchAllCustomer();
		List<Customer> customers = dao.fetchAllCustomer();
		if(customers != null) {
			return ResponseEntity.status(HttpStatus.OK).body(customers);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	//create api - to fetch customer based on id - PathVariable
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> fetchCustomerById(@PathVariable("id") int id) {
		Customer customer =  dao.fetchCustomerById(id);
		if(customer != null) {
			return ResponseEntity.status(HttpStatus.OK).body(customer);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	//create api - to delete customer based on id
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<String> removeCustomerById(@PathVariable("id") int id) {
		dao.removeCustomerById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Resource Deleted");
	}
	
	//create api - to update customer based on id
	@PutMapping("/customers/{id}")
	public Customer updateCustomerById(@RequestBody Customer customer,
									   @PathVariable("id") int id) {
		return dao.updateCustomerById(customer, id);
	}
	
	@GetMapping("/customers/name/{name}")
	public ResponseEntity<AppResponse> getCustomerByName(@PathVariable("name") String name){
		List<Customer> customers = dao.getCustomerByName(name);
		if(!customers.isEmpty()) {
			AppResponse response = new AppResponse(HttpStatus.OK, "Data found", customers);
//			return ResponseEntity.ok(response);
			return ResponseEntity.ok().body(response);
		}
		AppResponse response = new AppResponse(HttpStatus.NOT_FOUND, "No Data found", null);
//		return new ResponseEntity(response, HttpStatus.NOT_FOUND);
		return ResponseEntity.ok().body(response);
	}
	
	private final OrdersDao ordersDao;
	
	@PostMapping("/customers/{id}/orders")
	public ResponseEntity<AppResponse> addOrder(@RequestBody Orders order,
												@PathVariable("id") int customerId){
		Customer customer = dao.fetchCustomerById(customerId);
		if(customer != null) {
			order.setCustomer(customer);
			Orders orderAdded = ordersDao.addOrder(order);
			return ResponseEntity.ok().body(
					new AppResponse(HttpStatus.CREATED, "Order Added", orderAdded));
		}
		return ResponseEntity.ok().body(
				new AppResponse(HttpStatus.NOT_FOUND, "Verify Customer Id", null));
	}
	
	
	
	@GetMapping("/customers/{id}/orders")
	public ResponseEntity<AppResponse> fetchOrders(@PathVariable("id") int customerId){
		Customer customer = dao.fetchCustomerById(customerId);
		if(customer != null) {
			//returns empty list
			List<Orders> orders = customer.getOrders();
			if(!orders.isEmpty()) {
				return ResponseEntity.ok().body(
					new AppResponse(HttpStatus.OK, "Data found", orders));
			}
			return ResponseEntity.ok().body(
					new AppResponse(HttpStatus.NOT_FOUND, "No Orders found", null));
		}
		return ResponseEntity.ok().body(
				new AppResponse(HttpStatus.NOT_FOUND, "No Data found", null));
	}
}











