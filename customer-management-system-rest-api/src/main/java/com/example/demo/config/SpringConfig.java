package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SpringConfig implements CommandLineRunner {

	private final EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Stalin", "Dcruz", 65000));
		employees.add(new Employee("Alex", "Jo", 69000));
		employeeRepository.saveAll(employees);
	}

}
