package com.example.demo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.ErrorResponseModel;
import com.example.demo.service.EmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService employeeService;
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponseModel> handleError(EmployeeNotFoundException e)
	{
		ErrorResponseModel model=new ErrorResponseModel();
		model.setErorMessage(e.getMessage());
		model.setErrorCode(HttpStatus.NOT_FOUND.value());
		model.setErrorReportingTime(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(model);
	}

	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
	}

	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees() {
		return ResponseEntity.ok(employeeService.listEmployees());
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<?> findEmployeeById(@PathVariable("employeeId") int employeeId) {
		Optional<Employee> optional = employeeService.getEmployeeById(employeeId);

		if (optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("employee with " + employeeId + " not found");
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body(optional.get());
		}
	}

	@PutMapping
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		Employee e = employeeService.updateEmployeeById(employee);
		if (e == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("employee with employeeId " + employee.getEmployeeId() + "not found ");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(e);
		}
	}

	@DeleteMapping("/{employeeId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("employeeId") int employeeId) {

		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body("employee deleted..");

	}
	@GetMapping("/find/{firstName}")
	public ResponseEntity<?> findByFirstName(@PathVariable("firstName") String firstName)
	{
		List<Employee> employees=employeeService.findByFirstName(firstName);
		if(employees==null)
		{
			throw new EmployeeNotFoundException("employee with "+firstName+" not found");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.OK).body(employees);
		}
	}
	@GetMapping("/find/")
	public ResponseEntity<?> findByFirstNameOrLastName(@RequestParam(value = "firstName", required = false) String firstName,@RequestParam(value = "lastName", required = false) String lastName)
	{
		List<Employee> employees=employeeService.findByFirstNameOrLastName(firstName, lastName);

		if(employees==null)
		{
			throw new EmployeeNotFoundException("employee with "+firstName+" "+lastName+" not found");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.OK).body(employees);
		}
	}

}
