package com.my.AcademicClassRegistration.course.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import com.my.AcademicClassRegistration.exception.ResourceNotFoundException;

import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CourseNotFoundException extends ResourceNotFoundException{

	public CourseNotFoundException(String message) {
		super(message);
	}
	
}
