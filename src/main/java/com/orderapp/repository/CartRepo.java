package com.orderapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderapp.model.Cart;

import java.util.List;


public interface CartRepo extends JpaRepository<Cart,Long> {

	List<Cart> findByUserId(Long userId);
	
}
