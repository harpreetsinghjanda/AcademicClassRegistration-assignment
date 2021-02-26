package com.my.AcademicClassRegistration.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class AcademicClassRegistrationException extends ResponseEntityExceptionHandler{

	static final String FOR_DELETE_COULD_NOT_FIND_RESOURSE_ERROR_MESSAGE = "Resourse does not exist.";
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleCourseNotFoundExceptions(Exception ex, WebRequest request) throws Exception {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false));
	
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
		
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public final ResponseEntity<ExceptionResponse> handleEmptyResultDataAccesExceptions(EmptyResultDataAccessException ex, WebRequest request) throws Exception {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(FOR_DELETE_COULD_NOT_FIND_RESOURSE_ERROR_MESSAGE, request.getDescription(false));
	
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleSystemExceptions(Exception ex, WebRequest request) throws Exception {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false));
	
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
