package com.test.rest.services;

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
	 * Checks email existing in database
	 * @param email
	 * @return <code>true</code> when email exists
	 * @return <code>false</code> when email is absent 
	 */
	public boolean checkEmailExisting(String email);
}
