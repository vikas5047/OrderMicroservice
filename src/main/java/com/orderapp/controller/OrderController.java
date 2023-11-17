package com.orderapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderapp.bo.OrderDetailResponse;
import com.orderapp.bo.OrderInput;
import com.orderapp.bo.OrderItemResponse;
import com.orderapp.bo.OrderResponse;
import com.orderapp.model.Cart;
import com.orderapp.model.CartItem;
import com.orderapp.model.OrderHeader;
import com.orderapp.model.OrderItem;
import com.orderapp.model.Product;
import com.orderapp.repository.CartRepo;
import com.orderapp.repository.OrderHeaderRepo;
import com.orderapp.repository.ProductRepo;
import com.orderapp.service.OrderService;




@RestController
@RequestMapping("/order")
public class OrderController {

	 @Autowired
	  private CartRepo cartRepoRepo;
	 
	  @Autowired
	  private ProductRepo productRep;
	  
	  @Autowired
	  private OrderHeaderRepo orderRepo;
	  
	  @Autowired
	  OrderService orderService;
	  
	  @MutationMapping("createOrder")
	  public OrderDetailResponse createOrder(@Argument OrderInput orderInput) {
		  return orderService.createOrder(orderInput);
	      
	  
	  }
	  @QueryMapping("getUserOrders")
	  public List<OrderResponse> getUserOrders(@Argument Long userId){
		  
		List<OrderResponse> orders= orderService.getUserOrders(userId);
	     return orders;
	  }
	  
	  @QueryMapping("getOrderDetail")
	  public OrderDetailResponse getOrderDetail(@Argument Long orderId){
		  
		OrderDetailResponse order= orderService.getOrderDetail(orderId);
	     return order;
	  }
	  
	  @QueryMapping("getAllOrders")
	  public List<OrderResponse> getAllOrders(){
		  
		List<OrderResponse> orders= orderService.getAllOrders();
	     return orders;
	  }
	  
	 @PostMapping("/insert")
	 public OrderHeader insert(@RequestBody Cart cart){
	    	List<Cart> cartList = cartRepoRepo.findByUserId(cart.getUserId());
	    	Cart cartToOrder = null;
	    	double total = 0.0;
	    	OrderHeader orderHeader = null;
	    	if(cartList!=null && cartList.size()>0) {
	    		cartToOrder= cartList.get(0);
	    		 orderHeader = new OrderHeader();
	    		 orderHeader.setUserId(cart.getUserId());
	    		OrderItem orderItem = null;
	    		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
	    			for(CartItem crtIt :cartToOrder.getCartItems()) {
	    				
	    				orderItem = new OrderItem();
	    				Product prod = productRep.findById(Long.valueOf(crtIt.getProductId())).orElse(null);
	    						
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
	    		
	    	
	    	
	        return orderRepo.save(orderHeader);
	    }
	 
	 @PostMapping("/getUserOrders")
	 public List<OrderResponse> getUserOrders(@RequestBody OrderHeader orderReq){
		 
		 List<OrderResponse> response = new ArrayList<OrderResponse>();
		 List<OrderItemResponse> itemResps = new ArrayList<OrderItemResponse>();
		 OrderResponse resp = null;
		 List<OrderHeader> orderList = orderRepo.findByUserId(orderReq.getUserId());
		        //System.out.println(); .orElseThrow(() -> new RuntimeException("Book you are looking for not found on server !!"));;
		 if(orderList!=null && orderList.size()>0) {
			 for(OrderHeader order : orderList) {
			 //cart = cartList.get(0);
			 resp = new OrderResponse();	 
			 List<OrderItem> orderItems = order.getOrderItems();
			 resp.setOrderId(order.getOrderId());
			 resp.setUserId(order.getUserId());
			 resp.setOrderTotal(order.getOrderTotal());
			 OrderItemResponse itmResp = null;
			 for(OrderItem orderItem : orderItems) {
			
				 itmResp = new OrderItemResponse();
				Product prod = productRep.findById(Long.valueOf(orderItem.getProductId())).orElse(null);
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
