package com.test.rest.dao;

import com.test.rest.models.UserModel;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class UserDaoIpml extends AbstractDaoImpl<UserModel> implements UserDao {

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

	@SuppressWarnings("unchecked")
	public boolean isEmailExists(String email) {
		Session session = getSession();
		session.beginTransaction();

		List<UserModel> users = session.createQuery(" from com.test.rest.models.UserModel  User where User.email=:email").setString("email", email).list();

		closeSession(session);

		return users.size() == 0;
	}

	@SuppressWarnings("unchecked")
	public UserModel getByEmail(String email) {
		Session session = getSession();
		session.beginTransaction();

		List<UserModel> users = session.createQuery(" from com.test.rest.models.UserModel  User where User.email=:email").setString("email", email).list();

		closeSession(session);
		if (users.size()!=0)
			return users.get(0);
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

		return users.get(0);
	}
}