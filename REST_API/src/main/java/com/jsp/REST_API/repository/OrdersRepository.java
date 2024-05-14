package com.jsp.REST_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.REST_API.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{

}
