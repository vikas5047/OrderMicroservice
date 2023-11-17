package com.orderapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderapp.bo.CartItemResponse;
import com.orderapp.bo.CartResponse;
import com.orderapp.model.Cart;
import com.orderapp.model.CartItem;
import com.orderapp.model.Product;
import com.orderapp.repository.CartItemRepo;
import com.orderapp.repository.CartRepo;
import com.orderapp.repository.ProductRepo;
import com.orderapp.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	  @Autowired
	    private CartRepo cartRepoRepo;
	  @Autowired
	  private CartItemRepo cartItemRepo;
	  @Autowired
	  private ProductRepo productRep;

	  
		 
	 public CartResponse getUserCart(Long userId){
		 Cart cart = null; 
		 CartResponse response = new CartResponse();
		 List<CartItemResponse> itemResps = new ArrayList<CartItemResponse>();
		 Double total = 0.0;
		 List<Cart> cartList = cartRepoRepo.findByUserId(userId);
		        //System.out.println(); .orElseThrow(() -> new RuntimeException("Book you are looking for not found on server !!"));;
		 if(cartList!=null && cartList.size()>0) {
			 cart = cartList.get(0);
			 List<CartItem> cartItm = cart.getCartItems();
			 response.setCartId(cart.getCartId());
			 response.setUserId(cart.getUserId());
			 CartItemResponse itmResp = null;
			 for(CartItem cartItmz :cartItm) {
				 itmResp = new CartItemResponse();
				Product prod = productRep.findById(Long.valueOf(cartItmz.getProductId())).orElse(null);
				itmResp.setCartItemId(cartItmz.getCartItemId());
				itmResp.setProductId(cartItmz.getProductId());
				itmResp.setProductName(prod.getProductName());
				itmResp.setQuantity(cartItmz.getQuantity());
				itmResp.setSalesPrice(""+prod.getSalesPrice());
				itmResp.setListPrice(""+prod.getListPrice());
				if(prod!=null) {
			    	total = total+prod.getSalesPrice()*cartItmz.getQuantity();
			    }
				itemResps.add(itmResp);
			 }
			 response.setItems(itemResps);
			 response.setCartTotal(total);
		 }
		 return response;
	    }
	   
	    public CartResponse insert(Cart cart){
	    	List<Cart> cartList = cartRepoRepo.findByUserId(cart.getUserId());
	    	Cart cartToSave = null;
	    	CartResponse response = new CartResponse();
	    	if(cartList!=null && cartList.size()>0) {
	    		cartToSave= cartList.get(0);
	    		List<CartItem> cartItemsinDb =cartItemRepo.findByCart(cartToSave);
	    		if(cartItemsinDb!=null && cartItemsinDb.size()>0) {
	    			for(CartItem crtIt :cartItemsinDb) {
	    				for(CartItem reqItem : cart.getCartItems()) {
	    					Product prod = productRep.findById(Long.valueOf(reqItem.getProductId())).orElse(null);
	    					if(prod!=null) {
	    					if(crtIt.getProductId().equals(reqItem.getProductId()) ) {
	    						reqItem.setCartItemId(crtIt.getCartItemId());
	    						reqItem.setListPrice(""+prod.getListPrice());
	    						reqItem.setSalesPrice(""+prod.getSalesPrice());
	    					} else {
	    						reqItem.setListPrice(""+prod.getListPrice());
	    						reqItem.setSalesPrice(""+prod.getSalesPrice());
	    					}
	    					}
	    				}
	    			}
	    		}
	    	cartToSave.setCartItems(cart.getCartItems());
	    	}else {
	    		cartToSave = cart;
	    		for(CartItem reqItem : cart.getCartItems()) {
	    		Product prod = productRep.findById(Long.valueOf(reqItem.getProductId())).orElse(null);
	    		if(prod!=null) {
	    			reqItem.setListPrice(""+prod.getListPrice());
					reqItem.setSalesPrice(""+prod.getSalesPrice());
	    		}
	    		}
	    	}
	    	Cart cartresp  = cartRepoRepo.save(cartToSave);
	    	List<CartItemResponse> itemResps = new ArrayList<CartItemResponse>();
	    	List<CartItem> cartItm = cart.getCartItems();
			 response.setCartId(cartresp.getCartId());
			 response.setUserId(cartresp.getUserId());
			 CartItemResponse itmResp = null;
			 double total = 0.0;
			 for(CartItem cartItmz :cartItm) {
				 itmResp = new CartItemResponse();
				Product prod = productRep.findById(Long.valueOf(cartItmz.getProductId())).orElse(null);
				itmResp.setProductId(cartItmz.getProductId());
				itmResp.setProductName(prod.getProductName());
				itmResp.setQuantity(cartItmz.getQuantity());
				itmResp.setSalesPrice(""+prod.getSalesPrice());
				itmResp.setListPrice(""+prod.getListPrice());
				if(prod!=null) {
			    	total = total+prod.getSalesPrice()*cartItmz.getQuantity();
			    }
				itemResps.add(itmResp);
			 }
			 response.setItems(itemResps);
			 response.setCartTotal(total);
	        return response;
	    }
}
