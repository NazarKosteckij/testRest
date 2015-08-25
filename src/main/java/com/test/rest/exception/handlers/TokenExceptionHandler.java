package com.test.rest.exception.handlers;

public class TokenExceptionHandler implements ExceptionHandler {

	@Override
	public void handleException(Exception ex) {
		System.out.println("Token Exception ocured");
	}
	
}
