package org.example;

import java.util.Random;

import org.example.model.Department;
import org.example.model.Employee;
import org.example.model.Location;
import org.example.model.SpringConfig;
import org.example.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
       try {
    	   
    	   ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
    	   Employee e=context.getBean("employee",Employee.class);
    	   Department d=context.getBean("department",Department.class);
    	   Location l=context.getBean("location",Location.class);
    	   l.setLocationId(100);
    	   l.setLocationName("Hyd");
    	   l.setCounty("India");
    	   d.setDepartmentId(101);
    	   d.setDepartmentName("Sales");
    	   d.setLocation(l);
    	   e.setEmployeeId(new Random().nextInt(10000));
    	   e.setEmloyeeName("Dcruz");
    	   e.setSalary(51000);
    	   e.setDepartment(d);
    	   System.out.println(e);
    	   
    	   Student student=context.getBean("s",Student.class);
    	   student.setId(new Random().nextInt(100));
    	   student.setName("Stalin");
    	   System.out.println(student);
    	   
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
    }
}
