package com.test.rest.services;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.rest.contstants.users.UserGender;
import com.test.rest.contstants.users.UserRoles;
import com.test.rest.contstants.users.UserStatuses;
import com.test.rest.dao.UserDao;
import com.test.rest.models.UserModel;
import com.test.rest.utils.MD5;

public class UserServiceImpl implements UserService {

	private final String CONFIRMATION_URL = "http://localhost:8080/rest/confirmation/" ;

	@Autowired
	private UserDao userDao;

	@Autowired
	private EmailService emailService;

	private UserValidator userValidator = new UserValidator();

	/**
	 * {@inheritDoc}
	 * @return
	 */
	@Override
	public List<UserModel> getAll() {

		return userDao.getAll();
	}

	/**
	 * {@inheritDoc}
	 */
	public void addUser(UserModel user) {
		validateUser(user);
		user.setConfirmationHash(MD5.getMD5(user.getEmail()));
		userDao.create(user);
		emailService.sendConfirmation(user.getEmail(), CONFIRMATION_URL + user.getConfirmationHash());
	}

	/**
	 * {@inheritDoc}
	 */
	public UserModel getById(Integer id) {
		if(id>0)
			return userDao.read(id);
		else {
			throwException();
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void updateUser(UserModel user) {
		validateUser(user);

		if(user.getId()>0)
			userDao.update(user);
		else
			throwException();
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteUser(UserModel user) {
		validateUser(user);
		userDao.delete(user);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean checkEmailExisting(String email) {
		if(userValidator.validateEmail(email)){
			return userDao.isEmailExists(email);
		} else return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void confirmRegistration(String token) {
		UserModel user = userDao.getByToken(token);
		if(userIsNotConfirmedAndTokenValid(user, token)){
			emailService.sendNotification(user.getEmail(), "Your registration is completed.");
			user.setStatus(UserStatuses.STATUS_CONFIRMED);
			this.updateUser(user);
		}
		else {
			throw new IllegalArgumentException("Invalid token for this user or user already confirmed");
		}

	}

	public UserModel getByEmail(String email) {
		return userDao.getByEmail(email);
	}

	public EmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	private void validateUser(UserModel user){
		userValidator.validateUser(user);
	}

	public void throwException(){
		throw new NullPointerException();
	}

	/**
	 * @param user
	 * @param token
	 * @return true when user status isn't "confirmed" and token belongs this user else returns false
	 */
	private boolean userIsNotConfirmedAndTokenValid(final UserModel user, final String token) {
		return !user.getStatus().equals(UserStatuses.STATUS_CONFIRMED) && token.equals(MD5.getMD5(user.getEmail()));
	}


protected class UserValidator{
	private static final String EMAIL_PATTERN =
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private Matcher matcher;

	public UserValidator() {

	}

	public void validateUser(UserModel user){
		if(user != null){
			if(user.getRole()==null)
				user.setRole(UserRoles.ROLE_USER);
			if(user.getStatus()==null)
				user.setStatus(UserStatuses.STATUS_UNCONFIRMED);

			if(validateEmail(user.getEmail()) && validateGender(user.getGender())){
				if(validatePassword(user.getPassword())){
					
				} else {
					user.setPassword(MD5.getMD5(user.getPassword()));
				}
			} else throwException();
		}
	}
	
	protected boolean validateGender(final String gender) {
		return gender.equals(UserGender.GENDER_FEMALE) 
				|| gender.equals(UserGender.GENDER_MALE);
	}
	
	protected boolean validateEmail(final String email) {
		if (email != null) {
			Pattern pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(email);
			return matcher.matches();			
		} else return false; 
		
	}
	protected boolean validatePassword(final String password) {
		if(password.length() == 32)
			return true;
		else {
			return false;
		}
	}
 }
}
