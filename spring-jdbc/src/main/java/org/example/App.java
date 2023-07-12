package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.example.config.SpringConfig;
import org.example.model.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       try {
    	   
    	   ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
    	   DataSource dataSource=context.getBean("dataSource",DriverManagerDataSource.class);
    	   Car c=context.getBean("car",Car.class);
    	   c.setCarId(102);
    	   c.setCarName("Porsche");
    	   Connection connection=dataSource.getConnection();
    	   PreparedStatement pst=connection.prepareStatement("insert into car values(?,?)");
    	   pst.setInt(1, c.getCarId());
    	   pst.setString(2, c.getCarName());
    	   pst.executeUpdate();
    	   System.out.println("done");
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
    }
}