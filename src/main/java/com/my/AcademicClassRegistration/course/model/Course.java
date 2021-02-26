package com.my.AcademicClassRegistration.course.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.my.AcademicClassRegistration.professor.model.Professor;
import com.my.AcademicClassRegistration.student.model.Student;

@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class Course {

	@Id
	@GeneratedValue
	private Integer courseId;
	private String courseName;
	
	@OneToMany(mappedBy = "course")
	private List<Student> registeredStudents;
	
	@OneToMany(mappedBy = "course")
	private List<Professor> assignedProfessors;


	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public List<Professor> getAssignedProfessors() {
		return assignedProfessors;
	}
	public void setAssignedProfessors(List<Professor> assignedProfessors) {
		this.assignedProfessors = assignedProfessors;
	}
	public List<Student> getRegisteredStudents() {
		return registeredStudents;
	}
	public void setRegisteredStudents(List<Student> registeredStudents) {
		this.registeredStudents = registeredStudents;
	}

	
	
	
}
