package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "course_table")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int courseId;
	private String course;
	private double price;
	public Course(String course, double price) {
		super();
		this.course = course;
		this.price = price;
	}
}
