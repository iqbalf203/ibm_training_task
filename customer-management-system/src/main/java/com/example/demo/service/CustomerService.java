package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerService {
	
	public List<Customer> getAllCustomers();
	public void saveCustomer(Customer customer);
	public Customer findCustomerById(int customerId);
	public Customer updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
}
