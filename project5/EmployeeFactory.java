package project5;

import java.util.Scanner;
import java.util.UUID;

public class EmployeeFactory {
	
private Scanner scanner=new Scanner(System.in);
	
	public Employee createEmployee()
	{
		Employee emp=new Employee();
		System.out.print("Enter Employee Name: ");
		String eName=scanner.next();
		System.out.print("Enter Employee Salary: ");
		int eSalary=scanner.nextInt();
		
		
		System.out.print("Enter Department Name: ");
		String dName=scanner.next();
		Department d=createDepartment(dName);
		emp.setDepartment(d);
		emp.setEmployeeId(UUID.randomUUID().toString());
		emp.setEmployeeName(eName);
		emp.setEmployeeSalary(eSalary);
		return emp;
	}
	
	
	private Department createDepartment(String departmentName)
	{
		Department d=new Department();
		
		System.out.print("Enter Employee City: ");
		String city=scanner.next();
		System.out.print("Enter Employee Country: ");
		String country=scanner.next();
		System.out.print("Enter Employee Zip Code: ");
		int zip=scanner.nextInt();
		Location l=createLocation(city, zip, country);
		d.setDepartmentId(UUID.randomUUID().toString());
		d.setDepartmentName(departmentName);
		d.setLocation(l);
		return d;
		
		
	}
	
	
	private Location createLocation(String city,int zip,String countryName)
	{
		Location l=new Location();
		l.setLocationId(UUID.randomUUID().toString());
		l.setCity(city);
		l.setCountryName(countryName);
		l.setZipCode(zip);
		return l;
	}

}
