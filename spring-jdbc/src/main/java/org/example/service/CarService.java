package org.example.service;

import java.sql.SQLException;
import java.util.List;

import org.example.model.Car;
import org.springframework.stereotype.Component;

public interface CarService {
	public Car createCar(Car car)throws SQLException;
	public List<Car> getAllCars()throws SQLException;
	public List<Car> findById(int id) throws SQLException;
	public void deleteById(int id) throws SQLException;
	public void deleteAll() throws SQLException;
}
