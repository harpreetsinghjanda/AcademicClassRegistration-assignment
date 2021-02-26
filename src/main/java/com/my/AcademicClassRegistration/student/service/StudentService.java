package com.my.AcademicClassRegistration.student.service;

import java.util.List;

import com.my.AcademicClassRegistration.student.model.Student;

public interface StudentService {

	public List<Student> saveStudents(List<Student> students);
	
	public Student saveStudent(Student students);
	
	public List<Student> getStudents();
	
	public Student findStudent(Integer studentId);
	
	public void deleteStudent(Integer studentId);
	
}
