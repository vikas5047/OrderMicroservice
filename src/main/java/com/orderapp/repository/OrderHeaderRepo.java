package com.orderapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderapp.model.OrderHeader;

import java.util.List;


public interface OrderHeaderRepo extends JpaRepository<OrderHeader,Long> {

	public List<OrderHeader> findByUserId(Long userId);
}
