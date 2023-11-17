package com.orderapp.bo;

import java.util.List;

public class CartInput {

	private Long cartId;
	private Long userId;
	private List<CartItemInput> items;
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<CartItemInput> getItems() {
		return items;
	}
	public void setItems(List<CartItemInput> items) {
		this.items = items;
	}
	
	
	
}
