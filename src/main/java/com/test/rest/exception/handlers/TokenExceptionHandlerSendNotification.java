package com.test.rest.exception.handlers;

public class TokenExceptionHandlerSendNotification implements ExceptionHandler {

	@Override
	public void handleException(Exception ex) {
		System.out.println("Notification to admin was sent");
	}

}
