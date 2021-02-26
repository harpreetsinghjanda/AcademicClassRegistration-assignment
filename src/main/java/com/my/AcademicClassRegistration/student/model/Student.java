package com.my.AcademicClassRegistration.student.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.my.AcademicClassRegistration.course.model.Course;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private Integer studentId;
	private String firstName;
	private String lastName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Course course;
	

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Integer getCourseId() {
		return (this.getCourse() != null ? this.getCourse().getCourseId() : null);
	}


	
	
}
