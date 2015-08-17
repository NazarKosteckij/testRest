package com.test.rest.services;

import com.test.rest.models.UserModel;

public interface UserService {
	public void addUser(UserModel user);
	public UserModel getById(Integer id);
	public void updateUser(UserModel user);
	public void deleteUser(UserModel user);
}
