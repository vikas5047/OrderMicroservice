package com.orderapp.service;

import java.util.List;

import com.orderapp.bo.OrderDetailResponse;
import com.orderapp.bo.OrderInput;
import com.orderapp.bo.OrderResponse;


public interface OrderService {
	
	public OrderDetailResponse createOrder(OrderInput orderInput);
	public List<OrderResponse> getUserOrders(Long userId);
	public OrderDetailResponse getOrderDetail(Long orderId);
	public List<OrderResponse> getAllOrders();

}
