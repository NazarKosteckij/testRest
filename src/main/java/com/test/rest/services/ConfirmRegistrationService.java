package com.test.rest.services;

import com.test.rest.models.UserModel;

public interface ConfirmRegistrationService {
	
	/**
	 * Sends email with link of registration confirmation
	 * @param user
	 */
	public void sendConfirmationMail(final UserModel user);

	/**
	 * Checks confirmation token and confirms registration
	 * @param email
	 * @param token from link
	 */
	public void confirmRegistration(final String email, final String token);
}

