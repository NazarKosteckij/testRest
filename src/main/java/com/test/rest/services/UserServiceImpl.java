package com.test.rest.services;

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

	@Autowired
	private UserDao userDao;
	
	private UserValiator userValiator = new UserValiator();
	
	/**
	 * {@inheritDoc}
	 */
	public void addUser(UserModel user) {
		validateUser(user);
		userDao.create(user);
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
		if(userValiator.validateEmail(email)){
			return userDao.isEmailExists(email);
		} else return false;
	}
	
	private void validateUser(UserModel user){
		userValiator.validateUser(user);
	}
	
	private void throwException(){
		throw new NullPointerException();
	}
	
protected class UserValiator{
	private static final String EMAIL_PATTERN = 
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private Matcher matcher;

	public UserValiator() {
		
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
