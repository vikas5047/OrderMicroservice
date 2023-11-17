package com.orderapp.service;


import com.orderapp.bo.CartResponse;
import com.orderapp.model.Cart;


public interface CartService {

	public CartResponse getUserCart(Long userId);
	
	public CartResponse insert(Cart cart);
}
