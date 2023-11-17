package com.orderapp.service;

import com.orderapp.bo.ProductResponse;
import com.orderapp.model.Product;

public interface ProductService {

	public ProductResponse createProduct(Product product);
}
