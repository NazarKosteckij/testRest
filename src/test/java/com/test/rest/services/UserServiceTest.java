package com.test.rest.services;

import static org.junit.Assert.*;

import javax.swing.Spring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.test.rest.utils.email.EmailSender;


public class UserServiceTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() {
		EmailSender emailSender = new EmailSender();
		emailSender.sendMessage("silver_925@ukr.net","Hello from test", "JunitTest");
	}

}
