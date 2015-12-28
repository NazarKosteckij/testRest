package com.test.rest.services.users;

import com.test.rest.contstants.users.UserStatuses;
import com.test.rest.dto.UserDto;
import com.test.rest.models.UserModel;

import java.util.List;

public interface UserService {

	/**
	 * Gets all users from database
	 * @return List of users
	 */
	public List<UserDto> getAll();

	/**
	 * Creates user in database
	 * @param user
	 */
	public void addUser(UserDto user);
	
	/**
	 * Gets user by id
	 * @param id
	 * @return {@link UserModel}
	 */
	public UserDto getById(Integer id);
	
	/**
	 * Updates user
	 * @param user
	 */
	public void updateUser(UserDto user);
	
	/**
	 * Deletes user
	 * @param user
	 */
	public void deleteUser(UserDto user);
	
	/**
	 * Changes user's status to {@link UserStatuses.STATUS_CONFIRMED}
	 * @param token
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
	public UserDto getByEmail(String email);
}
