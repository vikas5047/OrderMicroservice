package com.orderapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderapp.bo.OrderDetailResponse;
import com.orderapp.bo.OrderInput;
import com.orderapp.bo.OrderItemResponse;
import com.orderapp.bo.OrderResponse;
import com.orderapp.bo.UserResponse;
import com.orderapp.model.Cart;
import com.orderapp.model.CartItem;
import com.orderapp.model.OrderHeader;
import com.orderapp.model.OrderItem;
import com.orderapp.model.Product;
import com.orderapp.repository.CartRepo;
import com.orderapp.repository.OrderHeaderRepo;
import com.orderapp.repository.ProductRepo;
import com.orderapp.service.OrderService;
import com.orderapp.service.UserService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	  private CartRepo cartRepoRepo;
	  @Autowired
	  private UserService userService;
	  @Autowired
	  private ProductRepo productRep;
	  
	  @Autowired
	  private OrderHeaderRepo orderRepo;
	  
	  
	 
	 public OrderDetailResponse createOrder(OrderInput orderInput){
	    	List<Cart> cartList = cartRepoRepo.findByUserId(orderInput.getUserId());
	    	Cart cartToOrder = null;
	    	double total = 0.0;
	    	OrderHeader orderHeader = null;
	    	if(cartList!=null && cartList.size()>0) {
	    		cartToOrder= cartList.get(0);
	    		 orderHeader = new OrderHeader();
	    		 orderHeader.setUserId(orderInput.getUserId());
	    		 orderHeader.setAddressId(orderInput.getAddressId());
	    		 orderHeader.setPaymentMode(orderInput.getPaymentMode());
	    		 orderHeader.setOrderStatus("CREATED");
	    		OrderItem orderItem = null;
	    		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
	    			for(CartItem crtIt :cartToOrder.getCartItems()) {
	    				
	    				orderItem = new OrderItem();
	    				Product prod = productRep.findById(crtIt.getProductId()).orElse(null);
	    						
	    						orderItem.setListPrice(""+prod.getListPrice());
	    						orderItem.setSalesPrice(""+prod.getSalesPrice());
	    						orderItem.setProductId(crtIt.getProductId());
	    						orderItem.setQuantity(crtIt.getQuantity());
	    						orderItemList.add(orderItem);
	    						total = total+prod.getSalesPrice()*crtIt.getQuantity();
	    					    
	    					}
	    			orderHeader.setOrderItems(orderItemList);
	    			orderHeader.setOrderTotal(total);
	    			}
	    		
	    	 orderRepo.save(orderHeader);
	    	
	        return getOrderDetail(orderHeader.getOrderId());
	    }
	 
	
	 public List<OrderResponse> getUserOrders(Long userId){
		 
		 List<OrderResponse> response = new ArrayList<OrderResponse>();
		 List<OrderItemResponse> itemResps = new ArrayList<OrderItemResponse>();
		 OrderResponse resp = null;
		 List<OrderHeader> orderList = orderRepo.findByUserId(userId);
		        //System.out.println(); .orElseThrow(() -> new RuntimeException("Book you are looking for not found on server !!"));;
		 if(orderList!=null && orderList.size()>0) {
			 for(OrderHeader order : orderList) {
			 //cart = cartList.get(0);
			 resp = new OrderResponse();	 
			 List<OrderItem> orderItems = order.getOrderItems();
			 resp.setOrderId(order.getOrderId());
			 resp.setUserId(order.getUserId());
			 resp.setOrderTotal(order.getOrderTotal());
			 resp.setPaymentMode(order.getPaymentMode());
			 resp.setAddressId(order.getAddressId());
			 resp.setOrderDate(order.getOrderDate().toString());
			 resp.setOrderStatus(order.getOrderStatus());
			 OrderItemResponse itmResp = null;
			 for(OrderItem orderItem : orderItems) {
			
				 itmResp = new OrderItemResponse();
				Product prod = productRep.findById(orderItem.getProductId()).orElse(null);
				itmResp.setProductId(orderItem.getProductId());
				itmResp.setProductName(prod.getProductName());
				itmResp.setQuantity(orderItem.getQuantity());
				itmResp.setSalesPrice(""+orderItem.getSalesPrice());
				itmResp.setListPrice(""+orderItem.getListPrice());
				/*if(prod!=null) {
			    	total = total+prod.getSalesPrice()*orderItem.getQuantity();
			    }*/
				itemResps.add(itmResp);
			 }
			 resp.setOrderItems(itemResps);
			 response.add(resp);
		 }
		 }
		 
		 return response;
	    }


	@Override
	public OrderDetailResponse getOrderDetail(Long orderId) {
		OrderHeader order =orderRepo.findById(orderId).orElse(null);
		OrderDetailResponse resp = new OrderDetailResponse();	 
		 List<OrderItem> orderItems = order.getOrderItems();
		 resp.setOrderId(order.getOrderId());
		 resp.setPaymentMode(order.getPaymentMode());
		 resp.setOrderTotal(order.getOrderTotal());
		 resp.setOrderDate(order.getOrderDate().toString());
		 resp.setOrderStatus(order.getOrderStatus());
		 OrderItemResponse itmResp = null;
		 List<OrderItemResponse> itemResps = new ArrayList<OrderItemResponse>();
		 for(OrderItem orderItem : orderItems) {
		
			 itmResp = new OrderItemResponse();
			Product prod = productRep.findById(orderItem.getProductId()).orElse(null);
			itmResp.setProductId(orderItem.getProductId());
			itmResp.setProductName(prod.getProductName());
			itmResp.setQuantity(orderItem.getQuantity());
			itmResp.setSalesPrice(""+orderItem.getSalesPrice());
			itmResp.setListPrice(""+orderItem.getListPrice());
			
			itemResps.add(itmResp);
		 }
		 UserResponse userResponse = userService.getUser(orderId);
		 resp.setItems(itemResps);
		 resp.setUser(userResponse);
		
		return resp;
	}
	
 public List<OrderResponse> getAllOrders(){
		 
		 List<OrderResponse> response = new ArrayList<OrderResponse>();
		 List<OrderItemResponse> itemResps = new ArrayList<OrderItemResponse>();
		 OrderResponse resp = null;
		 List<OrderHeader> orderList = orderRepo.findAll();
		        //System.out.println(); .orElseThrow(() -> new RuntimeException("Book you are looking for not found on server !!"));;
		 if(orderList!=null && orderList.size()>0) {
			 for(OrderHeader order : orderList) {
			 //cart = cartList.get(0);
			 resp = new OrderResponse();	 
			 List<OrderItem> orderItems = order.getOrderItems();
			 resp.setOrderId(order.getOrderId());
			 resp.setUserId(order.getUserId());
			 resp.setOrderTotal(order.getOrderTotal());
			 resp.setPaymentMode(order.getPaymentMode());
			 resp.setAddressId(order.getAddressId());
			 resp.setOrderDate(order.getOrderDate().toString());
			 resp.setOrderStatus(order.getOrderStatus());
			 OrderItemResponse itmResp = null;
			 for(OrderItem orderItem : orderItems) {
			
				 itmResp = new OrderItemResponse();
				Product prod = productRep.findById(orderItem.getProductId()).orElse(null);
				itmResp.setProductId(orderItem.getProductId());
				itmResp.setProductName(prod.getProductName());
				itmResp.setQuantity(orderItem.getQuantity());
				itmResp.setSalesPrice(""+orderItem.getSalesPrice());
				itmResp.setListPrice(""+orderItem.getListPrice());
				/*if(prod!=null) {
			    	total = total+prod.getSalesPrice()*orderItem.getQuantity();
			    }*/
				itemResps.add(itmResp);
			 }
			 resp.setOrderItems(itemResps);
			 response.add(resp);
		 }
		 }
		 
		 return response;
	    }

}
