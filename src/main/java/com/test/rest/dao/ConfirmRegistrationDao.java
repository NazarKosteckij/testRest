package com.test.rest.dao;

public interface ConfirmRegistrationDao {
	public void addToken(String token);
	public boolean getToken(String token);
}
