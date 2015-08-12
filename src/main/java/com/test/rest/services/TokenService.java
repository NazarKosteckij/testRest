package com.test.rest.services;

import org.springframework.stereotype.Service;

@Service
public interface TokenService {
	public String getPublicKey();

	public boolean isValid(String key);
	
	public void init();
}
