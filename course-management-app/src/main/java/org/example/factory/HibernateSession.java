package org.example.factory;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession{
	
	private static SessionFactory sessionFactory=null;
	
	private static Session session=null;
	
	
	public static Session getHibernateSession()throws Exception
	{
		sessionFactory=new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		session=sessionFactory.openSession();
		return session;
	}

}