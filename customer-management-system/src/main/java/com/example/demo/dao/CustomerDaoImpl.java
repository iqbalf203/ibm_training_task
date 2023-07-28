package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Customer;

@Repository
@EnableTransactionManagement
public class CustomerDaoImpl implements CustomerDao {

	private final EntityManager entityManager;


	public CustomerDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		TypedQuery<Customer> query=entityManager.createQuery("FROM Customer C",Customer.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		 entityManager.persist(customer);
	}

	@Override
	@Transactional
	public Customer findCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return entityManager.find(Customer.class, customerId);
	}

	@Override
	@Transactional
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return entityManager.merge(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		entityManager.remove(customer);
		
	}

}
