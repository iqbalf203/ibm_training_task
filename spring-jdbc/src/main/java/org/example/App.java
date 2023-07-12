package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import org.example.config.SpringConfig;
import org.example.dao.CarDao;
import org.example.model.Car;
import org.example.service.CarService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
	public static void main(String[] args) {
		try {

			ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
			CarService carService = context.getBean("carService", CarService.class);
			System.out.println("1: To Register Car");
			System.out.println("2: To Display All Cars");
			System.out.println("3: To Find Car by Id");
			System.out.println("4: To Delete Car by Id");
			System.out.println("5: To Delete All Cars");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1: {
				System.out.println("Enter Car Id:");
				int id = sc.nextInt();
				System.out.println("Enter Car Name:");
				String name = sc.next();
				Car c = carService.createCar(new Car(id, name));
				 System.out.println(c);
				 break;
			}
			case 2:{
				
				List<Car> cars=carService.getAllCars();
				for(Car cr:cars)
				{
					System.out.println(cr);
				}
				break;
			}
			case 3:{
				System.out.println("Enter Id No.");
				int id = sc.nextInt();
				List<Car> cars = carService.findById(id);
				for(Car cr:cars)
					{
						System.out.println(cr);
				}
				break;
				}
			case 4:{
				System.out.println("Enter Id No.");
				int id = sc.nextInt();
				carService.deleteById(id);
				break;
			}
			case 5:{
				carService.deleteAll();
				break;
			}
				
			}	
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
