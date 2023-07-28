package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Product;

@Repository
@EnableTransactionManagement
public class ProductDaoImpl implements ProductDao {
	
	private final EntityManager entityManager;

	public ProductDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Product> getAllProducts() {
		TypedQuery<Product> query=entityManager.createQuery("FROM Product C",Product.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void saveProduct(Product product) {
		entityManager.persist(product);
		
	}

	@Override
	@Transactional
	public Product findProductById(int productId) {
		return entityManager.find(Product.class, productId);
	}

	@Override
	@Transactional
	public Product updateProduct(Product product) {
		return entityManager.merge(product);
	}

	@Override
	@Transactional
	public void deleteProduct(Product product) {
		entityManager.remove(product);
		
	}

}
