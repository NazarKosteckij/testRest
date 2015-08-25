package com.test.rest.exception.handlers;

public class TokenExceptionHandlerWriteLog implements ExceptionHandler {

	@Override
	public void handleException(Exception ex) {
		System.out.println("Log: Exception ocured");
	}

}
