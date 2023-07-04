package com.ibm.customer_project.model;

import java.io.Serializable;

public class Customer implements Serializable{
	private int customer_id;
	private String customerFname;
	private String customerLname;
	private String customerEmail;
	public Customer() {
		
	}
	public Customer(int customer_id, String customerFname, String customerLname, String customerEmail) {
	
		this.customer_id = customer_id;
		this.customerFname = customerFname;
		this.customerLname = customerLname;
		this.customerEmail = customerEmail;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomerFname() {
		return customerFname;
	}
	public void setCustomerFname(String customerFname) {
		this.customerFname = customerFname;
	}
	public String getCustomerLname() {
		return customerLname;
	}
	public void setCustomerLname(String customerLname) {
		this.customerLname = customerLname;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	@Override
	public String toString() {
		return "Product [customer_id=" + customer_id + ", customerFname=" + customerFname + ", customerLname="
				+ customerLname + ", customerEmail=" + customerEmail + "]";
	}
	
	
	

}