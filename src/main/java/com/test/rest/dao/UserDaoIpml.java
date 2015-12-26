package com.test.rest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.test.rest.models.UserModel;

@Transactional
public class UserDaoIpml extends HibernateDaoSupport implements UserDao {
	
	public void create(UserModel user) {
		Session session = getSession();
		session.beginTransaction();
		session.save(user);

		closeSession(session);
	}

	@Override
	public List<UserModel> getAll() {
		Session session = getSession();
		session.beginTransaction();
		List<UserModel> users = session.createQuery(" from com.test.rest.models.UserModel  User").list();
		closeSession(session);
		return users;
	}


	public UserModel read(Integer id) {
		Session session = getSession();
		session.beginTransaction();
		UserModel userModel = (UserModel) session.get(UserModel.class, id);
		closeSession(session);
		return userModel;
	}
	
	public void update(UserModel user) {
		Session session = getSession();
		session.beginTransaction();

		session.update(user);

		closeSession(session);
	}

	
	public void delete(UserModel user) {
		Session session = getSession();
		session.beginTransaction();

		session.delete(user);

		closeSession(session);
	}

	@SuppressWarnings("unchecked")
	public boolean isEmailExists(String email) {
		Session session = getSession();
		session.beginTransaction();

		List<UserModel> users = session.createQuery(" from com.test.rest.models.UserModel  User where User.email=:email").setString("email", email).list();

		closeSession(session);

		if(users.size()!=0)
			return false;
		else 
			return true;
	}

	@SuppressWarnings("unchecked")
	public UserModel getByEmail(String email) {
		Session session = getSession();
		session.beginTransaction();

		List<UserModel> users = session.createQuery(" from com.test.rest.models.UserModel  User where User.email=:email").setString("email", email).list();

		closeSession(session);
		if (users.size()!=0)
			return (UserModel) users.get(0);
		else
			return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public UserModel getByToken(String token) {
		Session session = getSession();
		session.beginTransaction();

		List<UserModel> users = session.createQuery(" from com.test.rest.models.UserModel  User where User.confirmationHash=:confirmationHash").setString("confirmationHash", token).list();

		closeSession(session);

		return (UserModel) users.get(0);
	}

	private final void closeSession(Session session){
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
}