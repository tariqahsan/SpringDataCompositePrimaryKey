package com.javasampleapproach.compositeprimarykey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javasampleapproach.compositeprimarykey.model.OrderDetail;

public interface OrderRepository extends JpaRepository<OrderDetail, Integer>{
}