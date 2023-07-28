package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub

		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> listEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub

		Optional<Employee> emOptional = employeeRepository.findById(employeeId);
		if (emOptional == null) {
			return null;
		} else {
			return emOptional;
		}
	}

	@Override
	public Employee updateEmployeeById(Employee employee) {
		// TODO Auto-generated method stub

		Optional<Employee> oEmployee = employeeRepository.findById(employee.getEmployeeId());

		if (oEmployee.isEmpty()) {
			return null;
		}
		else
		{
			oEmployee.get().setFirstName(employee.getFirstName());
			oEmployee.get().setLastName(employee.getLastName());
			oEmployee.get().setSalary(employee.getSalary());
			
			employeeRepository.save(oEmployee.get());
			return oEmployee.get();

		}
	}

	@Override
	public void deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		
		Optional<Employee> oEmployee = employeeRepository.findById(employeeId);

		if (!oEmployee.isEmpty()) {
			
			
			employeeRepository.deleteById(employeeId);
		}
		else
		{
			throw new EmployeeNotFoundException("employee with given id not found..");
		}
		
	}

	@Override
	public List<Employee> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		List<Employee> employees=employeeRepository.findByFirstName(firstName);
		if(employees==null)
		{
			return null;
		}
		else
		{
			return employees;
		}
		
	}

	@Override
	public List<Employee> findByFirstNameOrLastName(String firstName, String lastName) {
		List<Employee> employees=employeeRepository.findByFirstNameOrLastName(firstName,lastName);
		if(employees==null)
		{
			return null;
		}
		else
		{
			return employees;
		}
	}

}
