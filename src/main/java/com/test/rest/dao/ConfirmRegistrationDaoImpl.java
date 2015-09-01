package com.test.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.test.rest.models.UserModel;
import com.test.rest.utils.MD5;

@Transactional
public class ConfirmRegistrationDaoImpl implements ConfirmRegistrationDao {

	@Autowired
	UserDao userDao;
	
	@Override
	public void addToken(String token) {
		System.err.println("WRITE TOKEN IN DATABASE " + token);
	}

	@Override
	public boolean getToken(String token) {
		UserModel user = userDao.getByToken(token);
		return MD5.getMD5(user.getEmail()).equals(token);
	}

}
