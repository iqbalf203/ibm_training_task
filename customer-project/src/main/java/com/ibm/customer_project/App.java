package com.ibm.customer_project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.ibm.customer_project.model.Product;


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
			Product product = new Product(id,fname,lname,email);
			List<Product> list=new ArrayList<Product>();
			list.add(product);
			output.writeObject(list);
			Object o=input.readObject();
			List<Product> list1=null;
			if(o instanceof List)
			{
				list1=(List<Product>)o;
			}
			
			for(Product p:list1)
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