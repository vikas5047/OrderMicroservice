package com.orderapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderapp.model.Cart;
import com.orderapp.model.CartItem;

import java.util.List;


public interface CartItemRepo extends JpaRepository<CartItem,Long> {

	List<CartItem> findByCart(Cart cart);
}
