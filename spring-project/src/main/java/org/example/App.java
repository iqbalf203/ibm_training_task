package org.example;

import java.util.Random;

import org.example.model.Department;
import org.example.model.Employee;
import org.example.model.Location;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       try {
    	   
    	   ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
    	   Employee e=context.getBean("employee",Employee.class);
    	   Department d=context.getBean("department",Department.class);
    	   Location l=context.getBean("location",Location.class);
    	   l.setLocationId(100);
    	   l.setLocationName("Hyd");
    	   l.setCountry("India");
    	   d.setDepartmentId(101);
    	   d.setDepartmentName("Sales");
    	   d.setLocation(l);
    	   e.setEmployeeId(new Random().nextInt(10000));
    	   e.setEmployeeName("John Doe");
    	   e.setEmployeeSalary(20000);
    	   e.setDepartment(d);
    	   System.out.println(e);
		
	} catch (Exception e) {
		// TODO: handle exception
		
		e.printStackTrace();
	}
    }
}