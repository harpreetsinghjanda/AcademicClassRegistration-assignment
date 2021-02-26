package com.my.AcademicClassRegistration.professor.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.my.AcademicClassRegistration.course.model.Course;

@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class Professor {

	@Id
	@GeneratedValue
	private Integer professorId;
	private String firstName;
	private String lastName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Course course;
	

	public Integer getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Integer professorId) {
		this.professorId = professorId;
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
