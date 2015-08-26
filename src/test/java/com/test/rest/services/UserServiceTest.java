package com.test.rest.services;

import static org.junit.Assert.*;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="UserServiceTest-context.xml")
public class UserServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		assertTrue(true);
	}

}
