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
@Table(name = "student_table")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	private String studentName;
	private String studentCourse;
	private int courseId;
	public Student(String studentName, String studentCourse,int courseId) {
		super();
		this.studentName = studentName;
		this.studentCourse = studentCourse;
		this.courseId = courseId;
	}
}
