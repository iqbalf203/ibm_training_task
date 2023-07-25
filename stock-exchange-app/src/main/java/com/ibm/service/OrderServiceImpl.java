package com.ibm.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.dao.OrderDao;
import com.ibm.model.Order;
@Component("service")
public class OrderServiceImpl implements OrderService {
	
	private OrderDao orderDao;
	@Autowired
	public OrderServiceImpl(OrderDao orderDao) {
		super();
		this.orderDao = orderDao;
	}

	@Override
	public int placeOrder(Order order,SessionFactory sessionFactory) {
		
		return orderDao.placeOrder(order,sessionFactory);
	}

	@Override
	public Order getOrder(int OrderNo,SessionFactory sessionFactory) {
		return orderDao.getOrder(OrderNo,sessionFactory);
	}

}
