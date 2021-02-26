package com.my.AcademicClassRegistration.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.AcademicClassRegistration.student.exception.StudentNotFoundException;
import com.my.AcademicClassRegistration.student.model.Student;
import com.my.AcademicClassRegistration.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepo;
	
	public List<Student> saveStudents(List<Student> students)	{
		return studentRepo.saveAll(students);
	}
	
	public Student saveStudent(Student students)	{
		return studentRepo.save(students);
	}
	
	public List<Student> getStudents() {
		return studentRepo.findAll();
	}
	
	public Student findStudent(Integer studentId) {
		
		Optional<Student> student =  studentRepo.findById(studentId);

		if( !student.isPresent()) {
			throw new StudentNotFoundException("Student Not found with ID : " + studentId);
		}
		
		return student.get();
		
	}
	
	public void deleteStudent(Integer studentId) {
		
		studentRepo.deleteById(studentId);
		
	}

}

