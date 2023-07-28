package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {
	public List<Product> getAllProducts();
	
	public void saveProduct(Product product);
	
	public Product findProductById(int productId);
	
	public Product updateProduct(Product product);
	
	public void deleteProduct(Product product);
}
