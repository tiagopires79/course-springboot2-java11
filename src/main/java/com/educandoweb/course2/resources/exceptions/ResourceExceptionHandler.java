package com.educandoweb.course2.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.course2.services.exceptions.DatabaseException;
import com.educandoweb.course2.services.exceptions.ResourceNotFoundException;

@ControllerAdvice // Irá interceptar as exceções e executar um tratamento
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class) // Irá interceptar qqer exceção deste tipo que for lançada e lançar uma personalizada.
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){		
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(),status.value(), error, e.getMessage(), request.getRequestURI());		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class) // Irá interceptar qqer exceção deste tipo que for lançada, e lançar uma personalizada.
	public ResponseEntity<StandardError> dataBaseException(DatabaseException e, HttpServletRequest request){		
		String error = "Database Exception";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(),status.value(), error, e.getMessage(), request.getRequestURI());		
		return ResponseEntity.status(status).body(err);
	}

}
