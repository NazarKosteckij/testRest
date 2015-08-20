package com.test.rest.services;

import org.springframework.stereotype.Service;

@Service
public interface TokenService {
	/**
	 * creates and returns new token
	 * @return Token
	 */
	public String getPublicKey();

	/**
	 * Checks token valid
	 * @param token
	 * @return 
	 */
	public boolean isValid(String key);
	
	/**
	 * init method
	 */
	public void init();
}
