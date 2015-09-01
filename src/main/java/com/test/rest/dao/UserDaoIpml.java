package com.test.rest.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.test.rest.models.UserModel;

@Transactional
public class UserDaoIpml extends HibernateDaoSupport implements UserDao {
	
	public void create(UserModel user) {
		getSession().save(user);
		getSession().flush();
	}

	
	public UserModel read(Integer id) {
		getSession().load(id, UserModel.class);
		return null;
	}

	
	public void update(UserModel user) {
		Session session=  getSession();
		session.update(user);
		session.flush();
	}

	
	public void delete(UserModel user) {
		getSession().delete(user);
		getSession().flush();
	}
	
	@SuppressWarnings("unchecked")
	public boolean isEmailExists(String email) {
		List<UserModel> users = getSession().createSQLQuery("SELECT * from users where email='" + email + "'" ).addEntity(UserModel.class).list();
		if(users.size()!=0)
			return false;
		else 
			return true;
	}

	@SuppressWarnings("unchecked")
	public UserModel getByEmail(String email) {
		List<UserModel> users = getSession().createSQLQuery("SELECT * from users where email='" + email + "'" ).addEntity(UserModel.class).list();
	return (UserModel) users.get(0);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public UserModel getByToken(String token) {
		List<UserModel> users = getSession().createSQLQuery("SELECT * from users where confirmationHash='" + token + "'" ).addEntity(UserModel.class).list();
		return (UserModel) users.get(0);
	}
}