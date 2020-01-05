package com.mimacom.carlos.mimacom.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mimacom.carlos.mimacom.model.ErrorResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class ExceptionHandlerController.
 */
@RestControllerAdvice
public class ExceptionHandlerController {
	
	/**
	 * Handle exception.
	 *
	 * @param e the e
	 * @return the response entity
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception e){
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
