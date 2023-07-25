package com.ibm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "stock_orders")
@Component
public class Order {
	
	@Id
	private int orderNo;
	
	private String stock; 

	private String action; 

	private int qunatity; 

	private double amount; 

	private double commission;

	
	
}
