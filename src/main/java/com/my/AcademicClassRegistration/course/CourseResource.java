package com.my.AcademicClassRegistration.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.my.AcademicClassRegistration.course.model.Course;
import com.my.AcademicClassRegistration.course.service.CourseService;
import com.my.AcademicClassRegistration.professor.model.Professor;
import com.my.AcademicClassRegistration.student.model.Student;

@RestController
public class CourseResource {

	@Autowired
	private CourseService courseService;
		
	@GetMapping("/courses")
	public List<Course> getCourses()	{
		return courseService.getCourses();
	}
	
	@PostMapping("/courses")
	@ResponseStatus(code = HttpStatus.CREATED)
	public List<Course> addCourses( @RequestBody List<Course> courses) {

		return courseService.addCourses(courses);
		
	}

	@GetMapping("/courses/{courseId}")
	public Course findCourses( @PathVariable int courseId) {
		
		return  courseService.findCourse(courseId);
				
	}
	
	
	@GetMapping("/courses/{courseId}/professors")
	public List<Professor> getProfessorsForCourse(@PathVariable int courseId) {
		
		Course course = courseService.findCourse(courseId);
				
		return course.getAssignedProfessors();
		
	}
	
	@GetMapping("/courses/{courseId}/students")
	public List<Student> getStudentsForCourse(@PathVariable int courseId) {
		
		Course course = courseService.findCourse(courseId);
				
		return course.getRegisteredStudents();
		
	}
	
	
	@DeleteMapping("/courses/{courseId}")
	public void deleteCourse(@PathVariable int courseId)	{
		
		courseService.deleteCourse(courseId);
		
	}
}
