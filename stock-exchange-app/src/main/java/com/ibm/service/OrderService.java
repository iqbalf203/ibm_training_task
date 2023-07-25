package com.ibm.service;

import org.hibernate.SessionFactory;

import com.ibm.model.Order;

public interface OrderService {
	public int placeOrder(Order order,SessionFactory sessionFactory);
	public Order getOrder(int OrderNo,SessionFactory sessionFactory);
}
