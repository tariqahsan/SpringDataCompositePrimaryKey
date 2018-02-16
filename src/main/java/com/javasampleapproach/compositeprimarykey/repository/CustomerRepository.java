package com.javasampleapproach.compositeprimarykey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javasampleapproach.compositeprimarykey.model.Customer;
import com.javasampleapproach.compositeprimarykey.model.CustomerId;

public interface CustomerRepository extends JpaRepository<Customer, CustomerId>{
}