package com.test.rest.services;

public interface EmailService {
	/**
	 * Sends notification on email
	 * @param email
	 */
	public void sendNotification(String email, String message);
	
	/**
	 * Sends register confirmation link on email
	 * @param email
	 */
	public void sendConfirmarion(String email, String link);
}
