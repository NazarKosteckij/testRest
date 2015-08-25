package com.test.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LocalExceptionHandler {
	
	private com.test.rest.exception.handlers.ExceptionHandler handler;
	
	public LocalExceptionHandler(com.test.rest.exception.handlers.ExceptionHandler handler) {
		this.handler = handler;		
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="IOException occured")
	@ExceptionHandler(TokenException.class)
	public void handleTokenException(Exception ex) {
		handler.handleException(ex);
	}
	
	@ResponseStatus(value=HttpStatus.CONFLICT, reason="Duplicate value")
	@ExceptionHandler(org.hibernate.exception.ConstraintViolationException.class)
	public void handleHibernateException(Exception ex){
		System.out.println("Duplicate value");
	}
	
}
