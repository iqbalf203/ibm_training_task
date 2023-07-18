package org.example.model;

public class Employee {

	private String employeeName;
	private double age;

	public Employee() {
		super();
	}

	public Employee(String employeeName, double age) {
		super();
		this.employeeName = employeeName;
		this.age = age;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

}
