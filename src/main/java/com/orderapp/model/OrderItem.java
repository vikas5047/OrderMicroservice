package com.orderapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Table(name ="order_item")
@Entity
public class OrderItem {

	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long orderItemId;
	   
		
	    @ManyToOne
	    @JoinColumn(name = "order_id",referencedColumnName = "orderId") 
	    private OrderHeader orderHeader;
		 
		private String listPrice;
		private String salesPrice;
		private String productId;
		private int quantity;
		public Long getOrderItemId() {
			return orderItemId;
		}
		public void setOrderItemId(Long orderItemId) {
			this.orderItemId = orderItemId;
		}
		
		
		public OrderHeader getOrderHeader()
		  { 
			return orderHeader;
		  
		  }
		public void  setOrderHeader(OrderHeader orderHeader) { 
			 this.orderHeader = orderHeader; 
		}
		 
		public String getListPrice() {
			return listPrice;
		}
		public void setListPrice(String listPrice) {
			this.listPrice = listPrice;
		}
		public String getSalesPrice() {
			return salesPrice;
		}
		public void setSalesPrice(String salesPrice) {
			this.salesPrice = salesPrice;
		}
		public String getProductId() {
			return productId;
		}
		public void setProductId(String productId) {
			this.productId = productId;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		
		
}
