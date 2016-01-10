package com.test.rest.services;

import com.test.rest.utils.tokens.TokenCache;
import org.springframework.beans.factory.annotation.Autowired;


public class TokenServiceImpl implements TokenService {
	
	private short size = 4;	 
	
	@Autowired
	TokenCache tokenCache;
	
	/**
	 * {@inheritDoc}
	 */
	public void init(){
		System.out.println(size);
	}
	public short getSize() {
		return size;
	}

	
	public void setSize(short size) {
		this.size = size;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getPublicKey() {
		String publicKey;
		
		publicKey = getRandomToken();
		tokenCache.addToken(publicKey);
		
		return publicKey;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean isValid(String key) {
		return tokenCache.isValid(key);
	}
	
	private String getRandomToken() {
		//Random rand = new Random((long) Math.random());
		String token = String.valueOf(Math.random());
		if(token.length()>size){
			token = token.substring(0, size);
		} else if (token.length() < size) {
			token.concat(String.valueOf(Math.random()).substring(0, token.length() - size));
		}
		return token;
	}
	
}
