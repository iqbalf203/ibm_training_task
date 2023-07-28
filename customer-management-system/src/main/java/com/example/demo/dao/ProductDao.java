package com.example.demo.dao;

import java.util.List;
import com.example.demo.model.Product;

public interface ProductDao {
	public List<Product> getAllProducts();
	
	public void saveProduct(Product product);
	
	public Product findProductById(int productId);
	
	public Product updateProduct(Product product);
	
	public void deleteProduct(Product product);

}
