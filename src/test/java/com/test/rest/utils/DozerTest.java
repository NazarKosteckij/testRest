package com.test.rest.utils;

import java.util.Date;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.Before;
import org.junit.Test;

import com.test.rest.dto.UserDto;
import com.test.rest.models.UserModel;

public class DozerTest {
	private final String EMAIL = "silve@uk.net";
	private final String FIRST_NAME = "Naz";
	private final String LAST_NAME = "kos";
	private final String PHONE = "+3809";
	private final String PASSWORD= MD5.getMD5("1111");
	private final String BIRTHDATE = "1995-08-28";
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Mapper mapper = new DozerBeanMapper();
		
		UserModel sourceObject = new UserModel();
		sourceObject.setFirstName(FIRST_NAME);
		sourceObject.setLastName(LAST_NAME);
		sourceObject.setEmail(EMAIL);
		sourceObject.setPassword(PASSWORD);
		sourceObject.setPhone(PHONE);
		
		//sourceObject.setBirthdate(new Date(11111L));
		System.out.println(sourceObject);
		
		UserDto destObject =  
		    mapper.map(sourceObject, UserDto.class);
		System.out.println(destObject);
		destObject.setBirthdate(BIRTHDATE);
		UserModel sourceObj2 =  mapper.map(destObject, UserModel.class);
		
		System.out.println(sourceObj2);
		
	}

}
