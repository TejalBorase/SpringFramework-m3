package com.jsp.REST_API.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.REST_API.dao.OrdersDao;
import com.jsp.REST_API.entity.Orders;
import com.jsp.REST_API.response.AppResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/resource2")
@RequiredArgsConstructor
public class OrdersController {
	
	private final OrdersDao dao;
	
	@GetMapping("/orders")
	public ResponseEntity<AppResponse> getAllOrders(){
		List<Orders> orders = dao.fetchAllOrders();
		if(!orders.isEmpty()) {
			return ResponseEntity.ok().body(
					new AppResponse(HttpStatus.OK, "Data found", orders));
		}
		return ResponseEntity.ok().body(
				new AppResponse(HttpStatus.NOT_FOUND, "No Data found", orders));
	}
}











