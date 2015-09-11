package com.test.rest.services;

import com.test.rest.contstants.users.UserStatuses;
import com.test.rest.models.UserModel;

public interface UserService {
	/**
	 * Creates user in database
	 * @param user
	 */
	public void addUser(UserModel user);
	
	/**
	 * Gets user by id
	 * @param id
	 * @return {@link UserModel}
	 */
	public UserModel getById(Integer id);
	
	/**
	 * Updates user
	 * @param user
	 */
	public void updateUser(UserModel user);
	
	/**
	 * Deletes user
	 * @param user
	 */
	public void deleteUser(UserModel user);
	
	/**
	 * Changes user's status to {@link UserStatuses.STATUS_CONFIRMED}
	 * @param user
	 */
	public void confirmRegistration(String token);
	
	/**
	 * Checks email existing in database
	 * @param email
	 * @return <code>true</code> when email exists
	 * @return <code>false</code> when email is absent 
	 */
	public boolean checkEmailExisting(String email);

	/**
	 * Gets user by email
	 * @param email
	 * @return {@link UserModel}
	 */
	public UserModel getByEmail(String email);
}
