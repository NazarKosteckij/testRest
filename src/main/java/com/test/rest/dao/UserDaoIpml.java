package com.test.rest.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.rest.models.UserModel;

public class UserDaoIpml implements UserDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void create(UserModel user) {
		Session session = sessionFactory.openSession();
		session.save(user);
	}
}
