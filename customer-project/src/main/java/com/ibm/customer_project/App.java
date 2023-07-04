package com.ibm.customer_project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.ibm.customer_project.model.Customer;


/**
 * Hello world!
 *
 */
public class App {
		FileInputStream inputStream=null;
		FileOutputStream outputStream=null;
		ObjectOutputStream output=null;
		ObjectInputStream input=null;
		
		public void writeData(int id, String fname, String lname, String email) throws IOException, ClassNotFoundException{
		try {
			inputStream = new FileInputStream("data.ser");
			outputStream = new FileOutputStream("data.ser");
			output = new ObjectOutputStream(outputStream);
			input=new ObjectInputStream(inputStream);
			Customer product = new Customer(id,fname,lname,email);
			List<Customer> list=new ArrayList<Customer>();
			list.add(product);
			output.writeObject(list);
			Object o=input.readObject();
			List<Customer> list1=null;
			if(o instanceof List)
			{
				list1=(List<Customer>)o;
			}
			
			for(Customer p:list1)
			{
				System.out.println(p);
			}

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			input.close();
			output.close();
		}
	}
	
}