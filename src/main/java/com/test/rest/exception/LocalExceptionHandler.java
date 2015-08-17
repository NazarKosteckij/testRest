package com.test.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LocalExceptionHandler {
		
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="IOException occured")
	@ExceptionHandler(TokenException.class)
	public void handleTokenException(Exception ex) {
		System.out.println(ex.getMessage());
	}
	
	@ResponseStatus(value=HttpStatus.CONFLICT, reason="Duplicate value")
	@ExceptionHandler(org.hibernate.exception.ConstraintViolationException.class)
	public void handleHibernateException(Exception ex){
		System.out.println(ex.getLocalizedMessage());
	}
}
