package com.mimacom.carlos.mimacom.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mimacom.carlos.mimacom.model.ErrorResponse;
import com.mimacom.carlos.utils.MimacomConstanst;

@ExtendWith(MockitoExtension.class)
public class ExceptionHandlerControllerTest implements MimacomConstanst{
	
	@InjectMocks
	private ExceptionHandlerController exceptionHandlerController;
	
	@Test
	public void exceptionHandlerOk() {
		
		ResponseEntity<ErrorResponse> response = this.exceptionHandlerController.handleException(new Exception(EXCEPTION_MESSAGE));
		
		assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
		assertEquals(response.getBody().getMessage(), EXCEPTION_MESSAGE);
	}

}
