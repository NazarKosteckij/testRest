package com.test.rest.dao;

import com.test.rest.models.UserModel;

public interface UserDao {
	public void create(UserModel user);

	public UserModel read(Integer id);

	public void update(UserModel user);

	public void delete(UserModel user);
	
}
