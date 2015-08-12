package com.test.rest.utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MD5Test {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetMD5() {
		String md5 = MD5.getMD5("1111");
		assertTrue("b59c67bf196a4758191e42f76670ceba".equals(md5));
	}

}
