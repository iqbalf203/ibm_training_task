package org.example.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Department {
	
	private int departmentId;
	private String departmentName;
	@Autowired
	private Location location;
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "department id: " + departmentId + " department name: " + departmentName + " location: "
				+ location;
	}
	@PostConstruct
    public void initStudent()
    {
        System.out.println("init method called...");
    }
    
    @PreDestroy
    public void destroyStudent()
    {
        System.out.println("destroy method called...");
    }

}
