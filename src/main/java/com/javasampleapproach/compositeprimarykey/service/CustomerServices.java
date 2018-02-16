package com.javasampleapproach.compositeprimarykey.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasampleapproach.compositeprimarykey.model.Customer;
import com.javasampleapproach.compositeprimarykey.repository.CustomerRepository;

@Service
public class CustomerServices {
	@Autowired
	CustomerRepository customerRepository;
	
	public void deleteAll(){
		customerRepository.deleteAll();
	}
	
	public void save(Customer customer){
		customerRepository.save(customer);
		customerRepository.flush();
	}
	
	@Transactional
	public void showAll(){
		List<Customer> custs = customerRepository.findAll();
		custs.forEach(System.out::println);
	}
}