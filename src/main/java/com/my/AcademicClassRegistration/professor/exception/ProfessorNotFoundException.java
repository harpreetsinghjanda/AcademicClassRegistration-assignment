package com.my.AcademicClassRegistration.professor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.my.AcademicClassRegistration.exception.ResourceNotFoundException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProfessorNotFoundException extends ResourceNotFoundException{

	public ProfessorNotFoundException(String message) {
		super(message);
	}
	
}
