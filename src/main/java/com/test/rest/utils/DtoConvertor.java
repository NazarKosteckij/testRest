package com.test.rest.utils;
import java.sql.Date;

import com.test.rest.dto.UserDto;
import com.test.rest.models.UserModel;

public class DtoConvertor {
	public static UserDto userToDto(UserModel user) {
		UserDto userDto = new UserDto();
		
		userDto.setBirthdate(user.getBirthdate().toString());
		userDto.setEmail(user.getEmail());
		userDto.setFirstName(user.getFirstName());
		userDto.setGender(user.getGender());
		userDto.setId(user.getId());
		userDto.setLastName(user.getLastName());
		userDto.setPassword(user.getPassword());
		userDto.setPhone(user.getPhone());
		
		return userDto;
	}
	
	public static UserModel creaUserFromDto(UserDto userDto) {
		UserModel userModel = new UserModel();
		userModel.setBirthdate(Date.valueOf(userDto.getBirthdate()));
		userModel.setEmail(userDto.getEmail());
		userModel.setFirstName(userDto.getFirstName());
		userModel.setGender(userDto.getGender());
		if(userDto.getId()!=null)
			userModel.setId(userDto.getId());
		userModel.setLastName(userDto.getLastName());
		userModel.setPassword(userDto.getPassword());
		userModel.setPhone(userDto.getPhone());
		
		
		return userModel;
	}
}
