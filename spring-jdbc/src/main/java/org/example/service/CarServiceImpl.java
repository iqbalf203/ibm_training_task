package org.example.service;

import java.sql.SQLException;
import java.util.List;

import org.example.dao.CarDao;
import org.example.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("carService")

public class CarServiceImpl implements CarService {
	private final CarDao carDao;

	@Autowired
	public CarServiceImpl(CarDao carDao) {

		this.carDao = carDao;
	}

	@Override
	public Car createCar(Car car) throws SQLException {
		// TODO Auto-generated method stub
		return carDao.createCar(car);
	}

	@Override
	public List<Car> getAllCars() throws SQLException {
		// TODO Auto-generated method stub
		return carDao.getAllCars();
}

	@Override
	public List<Car> findById(int id) throws SQLException {
		return carDao.findById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) throws SQLException {
		carDao.deleteById(id);
		
	}

	@Override
	public void deleteAll() throws SQLException {
		carDao.deleteAll();
		
	}
}
