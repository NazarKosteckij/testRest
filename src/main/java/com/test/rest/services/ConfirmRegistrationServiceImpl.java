/**
 * 
 */
package com.test.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.rest.contstants.users.UserStatuses;
import com.test.rest.dao.ConfirmRegistrationDao;
import com.test.rest.models.UserModel;
import com.test.rest.utils.MD5;

/**
 * @author nkostets
 *
 */
@Service
public class ConfirmRegistrationServiceImpl implements ConfirmRegistrationService {
	
	private final String CONFIRMATION_URL = "http://localhost:8080/rest/confirmation/";
	
	@Autowired
	EmailService emailService;

	@Autowired
	ConfirmRegistrationDao confirmRegistrationDao;
	
	@Autowired
	UserService userService;
	
	/**
	 * {@inheritDoc}
	 */
	public void sendConfirmationMail(final UserModel user) {
		final String confirmationToken= MD5.getMD5(user.getEmail());
		String link = CONFIRMATION_URL + confirmationToken + "?email=" + user.getEmail();
		confirmRegistrationDao.addToken(confirmationToken);
		emailService.sendConfirmarion(user.getEmail(), link);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void confirmRegistration(final String email, final String token) {
		UserModel user = userService.getByEmail(email);
		
		if(userIsNotConfirmedAndTokenValid(user, token)){
			if(confirmRegistrationDao.getToken(token)){
				userService.confirmRegistration(user);
				emailService.sendNotification(user.getEmail(), "Your registration is completed.");
			}
		}
		else {
			throw new IllegalArgumentException("Invalid token for this user or user alredy confirmed");
		}
	}
	
	/**
	 * @param user
	 * @param token
	 * @return true when user status isn't "confirmed" and token belongs this user else returns false
	 */
	private boolean userIsNotConfirmedAndTokenValid(final UserModel user, final String token) {
		return !user.getStatus().equals(UserStatuses.STATUS_CONFIRMED) && token.equals(MD5.getMD5(user.getEmail()));
	}

}
