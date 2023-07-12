package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.example.factory.CarFactory;
import org.example.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("carDao")
public class CarDaoImpl implements CarDao {

	private final CarFactory carFactory;

	private Connection connection = null;
	private List<Car> list = new ArrayList<>();

	@Autowired
	public CarDaoImpl(CarFactory carFactory) {

		this.carFactory = carFactory;
	}

	@Override
	public Car createCar(Car car) throws SQLException {
		// TODO Auto-generated method stub
		connection = carFactory.getMyConnection();
		PreparedStatement pStatement=connection.prepareStatement("insert into car values(?,?)");
		pStatement.setInt(1, car.getCarId());
		pStatement.setString(2, car.getCarName());
		pStatement.executeUpdate();
		return car;
	}

	@Override
	public List<Car> getAllCars() throws SQLException {
		// TODO Auto-generated method stub
		connection = carFactory.getMyConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select * from car");
		while(resultSet.next())
		{
			list.add(new Car(resultSet.getInt(1), resultSet.getString(2)));
		}
		return list;
	}
	
	public List<Car> findById(int id) throws SQLException{
		    List<Car> list1 = new ArrayList<>();
		    connection = carFactory.getMyConnection();
		    PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM car WHERE car_id = ?");
		    pStatement.setInt(1, id);
		    ResultSet resultSet = pStatement.executeQuery();
		    if (!resultSet.next()){System.out.println("Not Found...");}
		    
		    else {
		    while (resultSet.next()) {
		        Car car = new Car(resultSet.getInt(1), resultSet.getString(2));
		        list1.add(car);
		    }
		    }   
		    return list1;
		}
	
	public void deleteById(int id) throws SQLException{
		connection = carFactory.getMyConnection();
	    PreparedStatement pStatement = connection.prepareStatement("DELETE FROM car WHERE car_id = ?");
	    pStatement.setInt(1, id);
	    pStatement.executeUpdate();
	    System.out.println("id: "+id+" Deleted Successfully...");
	}
	
	public void deleteAll() throws SQLException{
		connection = carFactory.getMyConnection();
	    PreparedStatement pStatement = connection.prepareStatement("DELETE FROM car");
	    pStatement.executeUpdate();
	    System.out.println("Deleted All Successfully...");
	}
	
	}
