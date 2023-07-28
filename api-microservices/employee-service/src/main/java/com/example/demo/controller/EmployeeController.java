package com.example.demo.controller;

import org.springframework.core.env.Environment;	
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.EmployeeEntity;
import com.example.demo.service.EmployeeService;
import com.example.demo.ui.DepartmentDto;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;
	private final Environment environment;

	private final RestTemplate restTemplate;

	@GetMapping("/status")
	public ResponseEntity<?> status() {
		return ResponseEntity
				.ok("employee-service is up and runuing on port: " + environment.getProperty("local.server.port"));
	}

	@PostMapping("/{departmentName}")
	public ResponseEntity<?> createEmployee(@RequestBody EmployeeEntity employee,@PathVariable String departmentName) {
		Object o = restTemplate.getForObject("http://localhost:9999/DEPARTMENT-SERVICE/departments/" + departmentName,DepartmentDto.class);

		DepartmentDto dto = (DepartmentDto) o;
		employee.setDepartmentId(dto.getDepartmentId());
		employee.setDepartmentName(dto.getDepartmentName());
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
	}

}
