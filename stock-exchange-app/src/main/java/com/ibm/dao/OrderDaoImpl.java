package com.ibm.dao;

import java.util.List;	
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.ibm.model.Order;

@Component
public class OrderDaoImpl implements OrderDao {
	@Override
	public int placeOrder(Order order,SessionFactory sessionFactory) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(order);
		session.getTransaction().commit();
		System.out.println("one product created..");
		return order.getOrderNo();
	}

	@Override
	public Order getOrder(int OrderNo,SessionFactory sessionFactory) {
		Session session=sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
	List<Order> persons = session.createQuery("from Order ", Order.class).getResultList();
		int count = 0;
       for (Order person : persons) {
    	   if (person.getOrderNo()==OrderNo) {
    		   count +=1;
    		   System.out.println("-----------------");
    		   System.out.println("OrderNo.: "+person.getOrderNo());
    		   System.out.println("Stock: "+person.getStock());
    		   System.out.println("Action: "+person.getAction());
    		   System.out.println("Amount: "+person.getAmount());
    		   System.out.println("Commission: "+person.getCommission());
    		   System.out.println("Quantity: "+person.getQunatity());
    		   System.out.println("-----------------");
    	   }   
      }
     transaction.commit();
     if (count<=0) {System.out.println("No Record Found.");}
		return null;
	}

}
