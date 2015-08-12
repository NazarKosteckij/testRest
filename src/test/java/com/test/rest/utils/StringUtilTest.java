package com.test.rest.utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringUtilTest {
	
	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testRevertString() {
		if(StringUtil.revertString("sa").equals("as"))
			assertTrue(true);
		else fail();
	}

}
