package com.orderapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderapp.bo.CartInput;
import com.orderapp.bo.CartItemInput;
import com.orderapp.bo.CartResponse;
import com.orderapp.model.Cart;
import com.orderapp.model.CartItem;
import com.orderapp.service.CartService;




@RestController
@RequestMapping("/cart")
public class CartController {

	  @Autowired
	    private CartService cartService;
	 


	 @PostMapping("/getUserCart")
	 public CartResponse getUserCart(@RequestBody Cart cartreq){
		
		 return cartService.getUserCart(cartreq.getUserId());
	 }
	 
	 @CrossOrigin
	 @QueryMapping("getCart")
	 public CartResponse getCart(@Argument Long userId){
		
		 return cartService.getUserCart(userId);
	 }
    @PostMapping("/insert")
    public CartResponse insert(@RequestBody Cart cart){
    	
        return cartService.insert(cart);
    }
    
    @CrossOrigin
    @MutationMapping("addToCart")
    public CartResponse addToCart(@Argument CartInput cartInput){
    	Cart cart = new Cart();
    	CartItem itemInput = null;
    	List<CartItem> item = new ArrayList<CartItem>();
    	for(CartItemInput cartItemReq : cartInput.getItems()) {
    		itemInput = new CartItem();
    		itemInput.setProductId(cartItemReq.getProductId());
    		itemInput.setQuantity(cartItemReq.getQuantity());
    		item.add(itemInput);
    	}
    		
    	cart.setUserId(cartInput.getUserId());
    	cart.setCartItems(item);
        return cartService.insert(cart);
    }
    
    @CrossOrigin
    @QueryMapping("clearCart")
	 public String clearCart(@Argument Long userId){
    	
		 return cartService.deleteCart(userId);
	 }
}
