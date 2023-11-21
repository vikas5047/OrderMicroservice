package com.orderapp.controller;

import java.util.List;
																																																																													
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderapp.bo.OrderResponse;
import com.orderapp.bo.ProductInput;
import com.orderapp.bo.ProductResponse;
import com.orderapp.model.Product;
import com.orderapp.repository.ProductRepo;
import com.orderapp.service.ProductService;





@RestController
@RequestMapping("/product")
public class ProductController {
	
	
	    @Autowired
	    private ProductRepo productRep;
	    
	    @Autowired
	    ProductService productService;

	    @GetMapping("/findAll")
	   public List<Product> getAllProduct(){
	        return productRep.findAll();
	    }

	    @GetMapping("/findByProductId")
		public Product getProductById(@RequestBody Product product){
		     return productRep.findById(product.getProductId()).orElse(new Product());
		}
	    
	    @PostMapping("/insert")
	    public Product insert(@RequestBody Product product){
	    	
	        return productRep.save(product);
	    }
	    
	    @CrossOrigin
	    @MutationMapping("createProduct")
	    public ProductResponse createProduct(@Argument ProductInput productInput) {
	        Product product=new Product();
	        product.setProductId(productInput.getProductId());
	        product.setProductName(productInput.getProductName());
	        product.setProductImage(productInput.getProductImage());
	        product.setCurrency(productInput.getCurrency());
	        product.setListPrice(productInput.getListPrice());
	        product.setSalesPrice(productInput.getSalesPrice());
	        return this.productService.createProduct(product);
	    }
	    
	    @CrossOrigin
	    @QueryMapping("allProducts")
		 public List<Product> allProducts(){
			  
			List<Product> products= productService.getAllProduct();
		     return products;
		  }
	
	    @CrossOrigin
	    @QueryMapping("getProduct")
		public Product getProduct(@Argument String productId){
	    	return productService.getProductById(productId);
		}
}
