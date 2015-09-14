package com.test.rest.dao;

import com.test.rest.models.UserModel;

import java.util.List;

public interface UserDao {
	
	public void create(UserModel user);

	public List<UserModel> getAll();

	public UserModel read(Integer id);

	public void update(UserModel user);

	public void delete(UserModel user);
	
	public boolean isEmailExists(String email);
	
	public UserModel getByEmail(String email);
	
	public UserModel  getByToken(String token);
}
