package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;
@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductDao productDao;

	public ProductServiceImpl(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	@Override
	public void saveProduct(Product product) {
		productDao.saveProduct(product);
	}

	@Override
	public Product findProductById(int productId) {
		return productDao.findProductById(productId);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(product);
	}

	@Override
	public void deleteProduct(Product product) {
		productDao.deleteProduct(product);
		
	}

}
