package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

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
//			
//			 Car c = carService.createCar(new Car(100, "Porsche"));
//			 System.out.println(c);
			
//			List<Car> cars=carService.getAllCars();
//			for(Car cr:cars)
//			{
//				System.out.println(cr);
//			}
			List<Car> cars = carService.findById(100);
			for(Car cr:cars)
				{
					System.out.println(cr);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
