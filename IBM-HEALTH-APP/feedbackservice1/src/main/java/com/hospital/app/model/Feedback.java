package com.hospital.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long feedback_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "feedback_message")
	private String feedbackMessage;
	
	@Column(name = "experience")
	private String experience;
	
	
		
}
