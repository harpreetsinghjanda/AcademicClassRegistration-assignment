package com.my.AcademicClassRegistration.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.my.AcademicClassRegistration.course.model.Course;
import com.my.AcademicClassRegistration.course.service.CourseService;
import com.my.AcademicClassRegistration.student.model.Student;
import com.my.AcademicClassRegistration.student.service.StudentService;

@RestController
public class StudentrResource {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/students")
	public List<Student> getStudents()	{
		return studentService.getStudents();
	}
	
	@PostMapping("/students")
	@ResponseStatus(code = HttpStatus.CREATED)
	public List<Student> saveStudents( @RequestBody List<Student> students) {
		
		List<Student> addedStudents =  studentService.saveStudents(students);
		
		return addedStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student findStudent( @PathVariable int studentId) {
		
		return  studentService.findStudent(studentId);
				
	}
	
	
	@PatchMapping("/students/{studentId}/courses")
	public Student assignCoursesToStudent(@PathVariable int studentId,  @RequestBody Course course) {
		
		Course searchedCourse = courseService.findCourse(course.getCourseId());
		
		Student student = studentService.findStudent(studentId);
			
		student.setCourse(searchedCourse);
	
		return  studentService.saveStudent(student);

	}
	
	@GetMapping("/students/{studentId}/courses")
	public Course getCoursesForStudent( @PathVariable int studentId) {
		
		Student student = studentService.findStudent(studentId);
		
		return student.getCourse();
				
				
	}
	
	@DeleteMapping("/students/{studentId}")
	public void deleteStudent(@PathVariable int studentId)	{
		
		studentService.deleteStudent(studentId);
		
	}
	
	@DeleteMapping("/students/{studentId}/courses")
	public Student removeStudentFromCourse(@PathVariable int studentId) {
		
		Student student = studentService.findStudent(studentId);
		
		student.setCourse(null);
		
		return studentService.saveStudent(student);				
				
	}
}
