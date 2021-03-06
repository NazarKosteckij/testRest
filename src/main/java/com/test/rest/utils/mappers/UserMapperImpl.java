package com.test.rest.utils.mappers;

import com.test.rest.dto.UserDto;
import com.test.rest.models.UserModel;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class UserMapperImpl extends AbstractMapper<UserDto, UserModel> implements UserMapper{
	
	/**
	 * Converts {@link UserModel} into {@link UserDto}
	 * @param user {@link UserModel}
	 * @return {@link UserDto}
	 */
	public UserDto userToDto(UserModel user) {
		if (user == null)
			return null;

		UserDto userDto = new UserDto();

		if(user.getBirthdate() != null)
			userDto.setBirthdate(user.getBirthdate().toString());
		userDto.setEmail(user.getEmail());
		userDto.setFirstName(user.getFirstName());
		userDto.setGender(user.getGender());
		userDto.setId(user.getId());
		userDto.setLastName(user.getLastName());
		userDto.setPassword(user.getPassword());
		userDto.setPhone(user.getPhone());
		userDto.setGender(user.getGender());
		userDto.setRole(user.getRole());
		userDto.setStatus(user.getStatus());

		return userDto;
	}
	
	/**
	 * Converts {@link UserDto} into {@link UserModel}
	 * @param userDto {@link UserDto}
	 * @return {@link UserModel}
	 */
	public UserModel createUserFromDto(UserDto userDto) {
		UserModel userModel = new UserModel();
		if (userDto.getBirthdate()!=null)
			userModel.setBirthdate(Date.valueOf(userDto.getBirthdate()));
		userModel.setEmail(userDto.getEmail());
		userModel.setFirstName(userDto.getFirstName());
		userModel.setGender(userDto.getGender());
		if(userDto.getId()!= null)
			userModel.setId(userDto.getId());
		userModel.setLastName(userDto.getLastName());
		if(userDto.getPassword() != null)
			userModel.setPassword(userDto.getPassword());
		userModel.setPhone(userDto.getPhone());
		userModel.setGender(userDto.getGender());
		userModel.setRole(userDto.getRole());
		userModel.setStatus(userDto.getStatus());

		return userModel;
	}

	/**
	 *  Converts list of {@link UserModel} into list of  {@link UserDto}
	 * @param users list of {@link UserModel}
	 * @return List of {@link UserDto}
	 */
	public List<UserDto> userListToDtoList(List<UserModel> users){
		List<UserDto> usersDto = new LinkedList<UserDto>();
		for (UserModel user: users){
			usersDto.add(this.userToDto(user));
		}
		return usersDto;
	}

	/**
	 *  Converts list of {@link UserDto} into list of  {@link UserModel}
	 * @param users list of {@link UserDto}
	 * @return List of {@link UserDto}
	 */
	public List<UserModel> dtoListToUserList(List<UserDto> users){
		List<UserModel> userModels = new LinkedList<UserModel>();
		for (UserDto user: users){
			userModels.add(this.createUserFromDto(user));
		}
		return userModels;
	}

	@Override
	public UserDto businessObjFromDto(UserModel user) {
		return this.userToDto(user);
	}

	@Override
	public UserModel businessObjToDto(UserDto user) {
		return this.createUserFromDto(user);
	}

}
