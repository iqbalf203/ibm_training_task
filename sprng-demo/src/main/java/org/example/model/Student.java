package org.example.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("s")
@Scope(scopeName = "prototype")
public class Student {

	
	private String name;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
