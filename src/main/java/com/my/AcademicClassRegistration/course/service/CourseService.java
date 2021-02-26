package com.my.AcademicClassRegistration.course.service;

import java.util.List;

import com.my.AcademicClassRegistration.course.model.Course;

public interface CourseService {

	public List<Course> addCourses(List<Course> courses);
	public List<Course> getCourses();
	
	public Course findCourse(Integer courseId);

	public void deleteCourse(Integer courseId);
}
