package com.ibm.customer_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//registering driver
			DriverManager.registerDriver(new Driver());
			//establishing the connection
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","pass@word1");
			//creating statement object
			Statement statement=connection.createStatement();
			//storing query data into result set
			ResultSet rs= statement.executeQuery("select * from customers");
			//looping over resultset and retriving the data
			App app = new App();
			while(rs.next())
			{
				int id = rs.getInt("customer_id");
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				String email = rs.getString("email");
				app.writeData(id,fname, lname, email);
//				Object obj = (rs.getInt("customer_id")+","+rs.getString("first_name")+","+rs.getString("last_name")+","+rs.getString("email"));
//				app.writeData(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}