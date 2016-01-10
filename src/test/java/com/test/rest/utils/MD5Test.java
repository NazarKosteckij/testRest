package com.test.rest.utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MD5Test {
	private final String ENCODED_PASSWORD = "b59c67bf196a4758191e42f76670ceba";
	private final String PASSWORD = "1111";

	private  MD5 md5;

	@Before
	public void setUp() throws Exception {
		md5 = new MD5();
	}

	@Test
	public void testGetMD5() {
		String encodedPassword = MD5.getMD5(PASSWORD);
		assertEquals(ENCODED_PASSWORD, encodedPassword);
	}

	@Test
	public void testEncode() throws Exception {
		assertEquals(ENCODED_PASSWORD, md5.encode(PASSWORD));
	}

	@Test
	public void testMatches() throws Exception {
		assertEquals(true, md5.matches(ENCODED_PASSWORD, ENCODED_PASSWORD));
		assertEquals(true, md5.matches(PASSWORD, ENCODED_PASSWORD));
		assertEquals(false, md5.matches("foo", ENCODED_PASSWORD) );
	}
}
