package com.example.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("coversion_rate")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rate {
	
	private String from;
	private String to;
	private double value;

}
