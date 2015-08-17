package com.test.rest.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.rest.dao.UserDao;
import com.test.rest.models.UserModel;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public void addUser(UserModel user) {
		userDao.create(user);
	}
	
	public UserModel getById(Integer id) {
		return userDao.read(id);
	}

	
	public void updateUser(UserModel user) {
		userDao.update(user);
	}

	
	public void deleteUser(UserModel user) {
		userDao.delete(user);
	}

}
