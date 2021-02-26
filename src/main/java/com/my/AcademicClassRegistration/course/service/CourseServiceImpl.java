package com.my.AcademicClassRegistration.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.AcademicClassRegistration.course.exception.CourseNotFoundException;
import com.my.AcademicClassRegistration.course.model.Course;
import com.my.AcademicClassRegistration.course.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepo;
	
	public List<Course> addCourses(List<Course> courses)	{
		return courseRepo.saveAll(courses);
	}
	
	public List<Course> getCourses() {
		return courseRepo.findAll();
	}
	
	public Course findCourse(Integer courseId) {
		
		Optional<Course> course =  courseRepo.findById(courseId);

		if( !course.isPresent()) {
			throw new CourseNotFoundException("Course Not found with ID : "  + courseId);
		}
		
		return course.get();
		
	}
	

	public void deleteCourse(Integer courseId) {
		
		courseRepo.deleteById(courseId);
		
	}
}

