package com.my.AcademicClassRegistration.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.my.AcademicClassRegistration.exception.ResourceNotFoundException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends ResourceNotFoundException{

	public StudentNotFoundException(String message) {
		super(message);
	}
	
}
