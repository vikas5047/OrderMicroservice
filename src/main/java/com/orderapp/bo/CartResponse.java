package com.orderapp.bo;

import java.util.List;

public class CartResponse {

	private Long cartId;
	private Long userId; 
	private Double cartTotal;
	private List<CartItemResponse> items;
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
	public Double getCartTotal() {
		return cartTotal;
	}
	public void setCartTotal(Double cartTotal) {
		this.cartTotal = cartTotal;
	}
	public List<CartItemResponse> getItems() {
		return items;
	}
	public void setItems(List<CartItemResponse> items) {
		this.items = items;
	}
	
	
	
}
