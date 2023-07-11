package org.example;

import java.util.Random;

import org.example.model.Department;
import org.example.model.Employee;
import org.example.model.Location;
import org.example.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


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
    	   l.setCounty("India");
    	   d.setDepartmentId(101);
    	   d.setLocation(l);
    	   e.setEmployeeId(new Random().nextInt(10000));
    	   e.setDepartment(d);
    	   System.out.println(e);
    	   
    	   Student student=context.getBean("s",Student.class);
    	   System.out.println(student);
    	   Student student1=context.getBean("s",Student.class);
    	   System.out.println(student1);
    	   Student student2=context.getBean("s",Student.class);
    	   System.out.println(student2);
    	   System.out.println(student==student1 && student==student2);
    	   
    	   
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
    }
}
