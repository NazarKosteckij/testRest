package com.test.rest.utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringUtilTest {
	
	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testRevertString() {
		assertEquals("as",StringUtil.revertString("sa"));
	}

	@Test
	public void testRevertSingleChar() throws Exception {
		assertEquals("a",StringUtil.revertString("a"));
	}

}
