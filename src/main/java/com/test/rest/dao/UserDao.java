package com.test.rest.dao;

import com.test.rest.models.UserModel;

import java.util.List;

public interface UserDao extends Dao<UserModel> {
	public boolean isEmailExists(String email);
	
	public UserModel getByEmail(String email);
	
	public UserModel  getByToken(String token);
}
