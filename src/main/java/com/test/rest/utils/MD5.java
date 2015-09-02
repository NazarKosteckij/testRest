package com.test.rest.utils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.password.PasswordEncoder;
 
public class MD5 implements PasswordEncoder {
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

	@Override
	public String encode(CharSequence rawPassword) {
		String pass = (String)rawPassword;
		return getMD5(pass);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		String pass = (String)rawPassword;
		return pass.equals(encodedPassword);
	}
 
}