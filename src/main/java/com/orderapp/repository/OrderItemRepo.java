package com.orderapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderapp.model.OrderItem;



public interface OrderItemRepo extends JpaRepository<OrderItem,Long> {

}
