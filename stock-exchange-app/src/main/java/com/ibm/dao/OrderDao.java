package com.ibm.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.ibm.model.Order;
@Component
public interface OrderDao {
	public int placeOrder(Order order,SessionFactory sessionFactory);
	public Order getOrder(int OrderNo,SessionFactory sessionFactory);
}
