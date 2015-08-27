package com.test.rest.dao;

//TODO add implementation
public class ConfirmRegistrationDaoImpl implements ConfirmRegistrationDao {

	@Override
	public void addToken(String token) {
		System.err.println("WRITE TOKEN IN DATABASE " + token);
	}

	@Override
	public boolean getToken(String token) {
	
		return true;
	}

}
