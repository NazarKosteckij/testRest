package com.test.rest.utils.tokens;

public interface TokenCache {
	void addToken(String key);
	
	public boolean isValid(String key);
	
	long DEFAULT_TIME_TO_LIVE = 5000L;
}
