package org.example.model;

public class Address {
	private String line1;
	private String line2;
	public Address(String line1, String line2) {
		super();
		this.line1 = line1;
		this.line2 = line2;
	}
	@Override
	public String toString() {
		return "Address [line1=" + line1 + ", line2=" + line2 + "]";
	}
	
	
}
