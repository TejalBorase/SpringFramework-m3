package com.jsp.REST_API.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jsp.REST_API.entity.Orders;
import com.jsp.REST_API.repository.OrdersRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrdersDao {

	private final OrdersRepository repository;
	
	public Orders addOrder(Orders order) {
		return repository.save(order);
	}
	
	public List<Orders> fetchAllOrders(){
		return repository.findAll();
	}
}






