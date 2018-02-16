package com.javasampleapproach.compositeprimarykey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasampleapproach.compositeprimarykey.model.OrderDetail;
import com.javasampleapproach.compositeprimarykey.repository.OrderRepository;

@Service
public class OrderServices {
	
	@Autowired
	OrderRepository orderRepository;
	
	public void save(OrderDetail order){
		orderRepository.save(order);
	}
	
	public void deleteAll(){
		orderRepository.deleteAll();
	}
}