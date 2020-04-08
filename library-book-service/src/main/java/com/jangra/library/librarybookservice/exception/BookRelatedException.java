package com.jangra.library.librarybookservice.exception;

import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class BookRelatedException {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<BookValidationError> MethodArgumentNotValidError(MethodArgumentNotValidException ex){
		String message = ex.getBindingResult().getFieldError().getDefaultMessage();
		BookValidationError error = new BookValidationError("Invalid Request Body", message);
		return new ResponseEntity<BookValidationError>(error,HttpStatus.BAD_REQUEST);
	} 
	
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<BookValidationError> BookNotFoundError(ResponseStatusException ex){
		String message = ex.getReason();
		BookValidationError error = new BookValidationError("Invalid Request Body", message);
		return new ResponseEntity<BookValidationError>(error,HttpStatus.BAD_REQUEST);
	} 
	
    @ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<BookValidationError> constraintViolationError(ConstraintViolationException ex) {
        String message = ex.getMessage();
        BookValidationError error= new BookValidationError("Invalid Request Body", message);
        return new ResponseEntity<BookValidationError>(error,HttpStatus.BAD_REQUEST);
	}
	
    @ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<BookValidationError> EmptyResultDataAccessError(EmptyResultDataAccessException ex) {
        String message = ex.getMessage();
        BookValidationError error= new BookValidationError("Invalid Request URI", message);
        return new ResponseEntity<BookValidationError>(error,HttpStatus.BAD_REQUEST);
	}

    @ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<BookValidationError> NoSuchElementError(NoSuchElementException ex) {
        String message = ex.getMessage();
        BookValidationError error= new BookValidationError("Invalid Request URI", message);
        return new ResponseEntity<BookValidationError>(error,HttpStatus.BAD_REQUEST);
	}

    @ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<BookValidationError> IllegalArgumentError(IllegalArgumentException ex) {
        String message = ex.getMessage();
        BookValidationError error= new BookValidationError("Invalid Request URI", message);
        return new ResponseEntity<BookValidationError>(error,HttpStatus.BAD_REQUEST);
	}

    @ExceptionHandler(EntityNotFoundException.class)
   	public ResponseEntity<BookValidationError> EntityNotFoundError(EntityNotFoundException ex) {
           String message = ex.getMessage();
           BookValidationError error= new BookValidationError("Invalid Request URI", message);
           return new ResponseEntity<BookValidationError>(error,HttpStatus.BAD_REQUEST);
   	}

    
}
